NAME := image-transform

##### Compiler / analyzer common configuration.

CC = clang
LINKER = $(CC)

RM = rm -rf
MKDIR = mkdir -p

# Clang-tidy
CLANG_TIDY = clang-tidy

_noop =
_space = $(noop) $(noop)
_comma = ,

# Using `+=` to let user define their own checks in command line
CLANG_TIDY_CHECKS += $(strip $(file < clang-tidy-checks.txt))
CLANG_TIDY_ARGS = \
	-warnings-as-errors=* -header-filter="$(abspath $(INCDIR.main))/.*" \
	-checks="$(subst $(_space),$(_comma),$(CLANG_TIDY_CHECKS))" \

# Sanitizers
CFLAGS.none :=
CFLAGS.asan := -fsanitize=address
CFLAGS.lsan := -fsanitize=leak
CFLAGS.msan := -fsanitize=memory -fsanitize-memory-track-origins=2 -fno-omit-frame-pointer -fno-optimize-sibling-calls
CFLAGS.usan := -fsanitize=undefined

SANITIZER ?= none
ifeq ($(SANITIZER),)
override SANITIZER := none
endif

ifeq ($(words $(SANITIZER)),1)
ifeq ($(filter $(SANITIZER),all asan lsan msan usan none),)
$(error Please provide correct argument value for SANITIZER: all, asan, lsan, msan, usan or none)
endif
endif

# Using `+=` to let user define their own flags in command line
CFLAGS += $(CFLAGS.$(SANITIZER))
LDFLAGS += $(CFLAGS.$(SANITIZER))

ifeq ($(SANITIZER),none)
OBJDIR = obj
BUILDDIR = build
else
OBJDIR = obj/$(SANITIZER)
BUILDDIR = build/$(SANITIZER)
endif

##### Configuration for `main` target.

SOLUTION_DIR = solution

SRCDIR.main = $(SOLUTION_DIR)/src
INCDIR.main = $(SOLUTION_DIR)/include
OBJDIR.main = $(OBJDIR)/$(SOLUTION_DIR)

SOURCES.main += $(wildcard $(SRCDIR.main)/*.c) $(wildcard $(SRCDIR.main)/*/*.c)
TARGET.main  := $(BUILDDIR)/$(NAME)

CFLAGS.main += $(strip $(file < $(SOLUTION_DIR)/compile_flags.txt)) $(CFLAGS) -I$(INCDIR.main)

##### Configuration for `tester` target.

TESTER_DIR = tester
TESTER_SCRIPT = $(TESTER_DIR)/tester.sh

SRCDIR.tester = $(TESTER_DIR)/src
INCDIR.tester = $(TESTER_DIR)/include
OBJDIR.tester = $(OBJDIR)/$(TESTER_DIR)

SOURCES.tester += $(wildcard $(SRCDIR.tester)/*.c)
TARGET.tester  := $(BUILDDIR)/image-tester

CFLAGS.tester += $(strip $(file < $(TESTER_DIR)/compile_flags.txt)) $(CFLAGS) -I$(INCDIR.tester)

##### Rule templates. Should be instantiated with $(eval $(call template, ...))

# I use $$(var) in some variables to avoid variable expanding too early.
# I do not remember when $(var) is expanded in `define` rules, but $$(var)
# is expanded exactly at $(eval ...) call.

# Template for running submake on each SANITIZER value when SANITIZER=all is used. 
# $(1) - SANITIZER value (none/asan/lsan/msan/usan)
define make-sanitizer-rule

GOALS.$(1) := $$(patsubst %,%.$(1),$$(MAKECMDGOALS))

$$(MAKECMDGOALS): $$(GOALS.$(1))
.PHONY: $$(GOALS.$(1))

$$(GOALS.$(1)):
	@echo Running 'make $$(patsubst %.$(1),%,$$@)' with SANITIZER=$(1)
	@$(MAKE) $$(patsubst %.$(1),%,$$@) SANITIZER=$(1)

endef

# Template for compilation and linking rules + depfile generation and inclusion
# $(1) - target name (main/tester)
define make-compilation-rule

OBJECTS.$(1) := $$(SOURCES.$(1):$$(SRCDIR.$(1))/%.c=$$(OBJDIR.$(1))/%.o)
SRCDEPS.$(1) := $$(OBJECTS.$(1):%.o=%.o.d)

DIRS.$(1) := $$(sort $$(dir $$(OBJECTS.$(1)) $$(TARGET.$(1))))
DIRS += $$(DIRS.$(1))

.PHONY: build-$(1)

build-$(1): $$(TARGET.$(1))

$$(TARGET.$(1)): $$(OBJECTS.$(1)) | $$(DIRS.$(1))
	$(LINKER) $(LDFLAGS) $$(OBJECTS.$(1)) -o $$@

$$(OBJDIR.$(1))/%.o: $$(SRCDIR.$(1))/%.c | $$(DIRS.$(1))
	$(CC) $(CFLAGS.$(1)) -c $$< -o $$@ -MD -MF $$@.d -MP

-include $$(SRCDEPS.$(1))

endef

# Template for testing rules.
# $(1) - directory with test
define make-test-rule

TST_NAME.$(1) := $$(notdir $(1))

TST_INPUT.$(1) := $(1)/input.bmp
TST_PARAM.$(1) := $(strip $(shell cat $(1)/param))
TST_ERR_CODE.$(1) := $(strip $(shell cat $(1)/err_code))
TST_OUTPUT.$(1) := $(OBJDIR.tester)/$$(TST_NAME.$(1)).bmp
TST_EXPECTED.$(1) := $(1)/output_expected.bmp

TST_LOG_OUT.$(1) := $(OBJDIR.tester)/$$(TST_NAME.$(1))_out.log
TST_LOG_ERR.$(1) := $(OBJDIR.tester)/$$(TST_NAME.$(1))_err.log

.PHONY: $$(TST_OUTPUT.$(1)) test-$$(TST_NAME.$(1))
test: test-$$(TST_NAME.$(1))

test-$$(TST_NAME.$(1)): build-main build-tester
	$(TESTER_SCRIPT) $$(TST_NAME.$(1)) \
		--main-cmd '$(TARGET.main) $$(TST_INPUT.$(1)) $$(TST_OUTPUT.$(1)) $$(TST_PARAM.$(1))' \
		--tester-cmd '$(TARGET.tester) $$(TST_OUTPUT.$(1)) $$(TST_EXPECTED.$(1))' \
		--log-dir '$(OBJDIR.tester)' \
    --err-code '$$(TST_ERR_CODE.$(1))'

endef

##### Rules and targets.

.PHONY: all test clean check

ifeq ($(MAKECMDGOALS),)
MAKECMDGOALS := all
endif


ifeq ($(SANITIZER),all)
# Do all the work in sub-makes
$(foreach sanitizer,none asan lsan msan usan,$(eval $(call make-sanitizer-rule,$(sanitizer))))
else

all: build-main

check:
	$(CLANG_TIDY) $(CLANG_TIDY_ARGS) $(SOURCES.main)

$(foreach target,main tester,$(eval $(call make-compilation-rule,$(target))))
$(foreach test,$(sort $(wildcard $(TESTER_DIR)/tests/*)),$(eval $(call make-test-rule,$(test))))

clean:
	$(RM) $(OBJDIR) $(BUILDDIR)

$(sort $(DIRS)):
	$(MKDIR) $@

endif
