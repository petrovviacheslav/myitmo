BUILD=nasm -f elf64 -o

all: main

%.o: %.asm
	$(BUILD) $@ $<

main: lib.o dict.o main.o
	ld -o main *.o

test: main test.py
	python3 test.py

clean:
	rm -f build/*.o main

.PHONY: all clean test
