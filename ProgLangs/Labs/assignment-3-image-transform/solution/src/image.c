#include "image.h"
#include <stdlib.h>


struct image make_img (uint64_t width, uint64_t height) {
    // struct image *img = malloc(sizeof(struct image));
    // img->width = width;
    // img->height = height;
    // img->data = malloc(width * height * sizeof(struct pixel));
    // return img;
    return (struct image) {
      .width = width,
      .height = height,
      .data = malloc(sizeof(struct pixel) * height * width)
    };
}

// ou yes, kill him, finish him)))
void kill_img (struct image* img) {
    free(img->data);
    //free(img);
}
