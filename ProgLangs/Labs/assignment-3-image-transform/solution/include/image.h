#ifndef IMAGE_H
#define IMAGE_H
#include <stdint.h>


struct pixel { uint8_t b, g, r;};

struct image
{
    uint64_t width, height;
    struct pixel* data;
};

struct image make_img(uint64_t width, uint64_t height);

void kill_img(struct image* img);

#endif
