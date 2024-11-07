#ifndef HANDLER_H
#define HANDLER_H
#include "image.h"
#include <stdio.h>


enum read_code {
    R_OK = 0,
    MEMORY_ERROR,
    R_INVALID_HEADER,
    R_INVALID_SIGNATURE,
    R_INVALID_BIT_COUNT,
    R_ERR
};

enum write_code {
    W_OK = 0,
    W_HEADER_ERR,
    W_IMG_ERR
};

uint8_t get_num_add_bytes(uint64_t width);
enum read_code from_bmp(FILE* input, struct image* img);
enum write_code to_bmp(FILE* output, struct image const* img);


#endif
