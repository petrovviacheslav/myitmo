# CMP0007: list command no longer ignores empty elements.
if(POLICY CMP0007)
    cmake_policy(SET CMP0007 NEW)
endif()

set(ENV{ASAN_OPTIONS} "allocator_may_return_null=true")
set(ENV{LSAN_OPTIONS} "allocator_may_return_null=true")
set(ENV{MSAN_OPTIONS} "allocator_may_return_null=true")

function(exec_check)
    if(ARGC EQUAL 5)
        execute_process(COMMAND ${ARGV1} ${ARGV2} ${ARGV3} ${ARGV4}
            OUTPUT_VARIABLE out
            ERROR_VARIABLE  err
            RESULT_VARIABLE result)
    elseif(ARGC EQUAL 4)
        execute_process(COMMAND ${ARGV1} ${ARGV2} ${ARGV3}
            OUTPUT_VARIABLE out
            ERROR_VARIABLE  err
            RESULT_VARIABLE result)
    else()
        message(FATAL_ERROR "Internal tester error\n")
    endif()
    if(NOT (result EQUAL ARGV0))
        string(REPLACE "/" ";" name_components ${ARGV1})
        list(GET name_components -1 name)
        if(NOT out)
            set(out "<empty>")
        endif()
        if(NOT err)
            set(err "<empty>")
        endif()
        message(FATAL_ERROR "\nError running \"${name}\"\n*** Output: ***\n${out}\n*** Error: ***\n${err}\n*** Error code: ***\n${result}\n")
    endif()
endfunction()

file(STRINGS ${TEST_DIR}/param PARAM)
file(STRINGS ${TEST_DIR}/err_code ERR_CODE)
file(REMOVE ${TEST_DIR}/output.bmp)
exec_check(${ERR_CODE} ${IMAGE_TRANSFORM} ${TEST_DIR}/input.bmp ${TEST_DIR}/output.bmp ${PARAM})
if(ERR_CODE EQUAL 0)
    exec_check(0 ${IMAGE_MATCHER} ${TEST_DIR}/output.bmp ${TEST_DIR}/output_expected.bmp)
endif()

