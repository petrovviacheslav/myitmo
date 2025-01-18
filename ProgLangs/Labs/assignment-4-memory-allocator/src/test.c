#include <assert.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "mem.h"
#include "test.h"

#define HEAP_SIZE 1024

// проверка указателя и вывод ошибки при == NULL
void valid_pointer(void* ptr, const char* test_name) {
    if (ptr == NULL) {
        printf("Test '%s' FAILED: pointer is NULL\n", test_name);
        exit(1);
    }
    printf("Test '%s' PASSED\n", test_name);
}

void is_pointer_NULL(void* ptr, const char* test_name) {
    if (ptr != NULL) {
        printf("Test '%s' FAILED: pointer is not NULL\n", test_name);
        exit(1);
    }
    printf("Test '%s' PASSED, ptr = NULL\n", test_name);
}


void test_malloc(void) {
    void* block = _malloc(32);
    valid_pointer(block, "test_malloc");
    _free(block);
}

// проверка очищения всех блоков из 3
void test_free_all_blocks(void) {
    printf("Test: Free all allocated blocks\n");
    void* block1 = _malloc(32);
    void* block2 = _malloc(64);
    void* block3 = _malloc(128);

    valid_pointer(block1, "test_free_two_block (block1)");
    valid_pointer(block2, "test_free_two_block (block2)");
    valid_pointer(block3, "test_free_two_block (block3)");

    _free(block1);
    _free(block2);
    _free(block3);
}

// проверка выделения нового региона 1024
void test_max_region(void) {
    void* block = _malloc(1024);
    valid_pointer(block, "test_max_region");
    _free(block);
}


void test_repeated(void) {
    for (int i = 0; i < 100; ++i) {
        void* block = _malloc(1024);
        valid_pointer(block, "test_repeated");
        _free(block);
    }

}

bool run_tests(void) {
    heap_init(HEAP_SIZE * HEAP_SIZE);

    test_malloc();
    test_free_all_blocks();
    test_max_region();
    test_repeated();

    heap_term();

    printf("All tests completed.\n");
    return true;
}
