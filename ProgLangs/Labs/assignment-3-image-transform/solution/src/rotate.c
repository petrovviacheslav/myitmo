#include "rotate.h"

#include <stdio.h>
#include <string.h>

struct image rotate90 (struct image *img) {
    struct image new = make_img(img->height, img->width);

    for (size_t i = 0; i < img->height; i++) {
        for(size_t j = 0; j < img->width; j++) {
            new.data[(j+1) * new.width - i- 1] = img->data[img->width * i + j];
        }
    }

    kill_img(img);
    return new;
}

struct image fliph(struct image *img) {
    struct image result = make_img(img->width, img->height);

    for (size_t i = 0; i < img->height; i++) {
        for(size_t j = 0; j < img->width; j++) {
            result.data[i * result.width + j] = img->data[i * result.width + (img->width - j - 1)];
        }
    }

    kill_img(img);
    return result;
}

struct image flipv (struct image *img) {
    struct image result = make_img(img->width, img->height);

    for (size_t i = 0; i < img->height; i++) {
        for(size_t j = 0; j < img->width; j++) {
            result.data[i * result.width + j] = img->data[(img->height - i - 1) * img->width + j];
        }
    }

    kill_img(img);
    return result;
}

struct image rotate (struct image *img, char *value) {

    struct image result = *img;// *img;

    if (strcmp(value, "ccw90") == 0) result = rotate90(&result);
    else if (strcmp(value, "cw90") == 0) {
        result = rotate90(&result);
        result = rotate90(&result);
        result = rotate90(&result);
    }
    else if (strcmp(value, "fliph") == 0){
        result = fliph(&result);
    }
    else if (strcmp(value, "flipv") == 0){
        result = flipv(&result);
    }

    return result;
}
