#include "handler.h"
#include "bmp_header.h"
#include <stdlib.h>

#define H_TYPE 0x4D42
#define H_RESERVED 0
#define H_SIZE  40
#define H_PLANES 1
#define H_BIT_COUNT 24
#define H_COMPRESSION 0
#define X_PELS_PER_METER 1
#define Y_PELS_PER_METER 1
#define CLR_USED 0
#define CLR_IMPORTANT 0


// функция подсчёта количества нужных доп байт
uint8_t get_num_add_bytes(const uint64_t width) {

    // сколько байт надо добавить, чтобы кол-во байт в строке было кратно 4
    return (4 - (width * sizeof(struct pixel)) % 4) % 4;
}

enum write_code to_bmp(FILE* output, const struct image* img) {
    
    // сколько байт надо добавить, чтобы кол-во байт в строке было кратно 4
    uint8_t additional_characters_to_four = get_num_add_bytes(img->width);

    // итоговый размер строги
    uint64_t row = img->width * sizeof(struct pixel) + additional_characters_to_four;

    //структура header
    struct bmp_header header = {
            .bfType = H_TYPE,
            .biWidth = img->width,
            .biHeight = img->height,
            .biSizeImage = row * img->height,
            .bOffBits = sizeof(struct bmp_header),
            .bfileSize = sizeof(struct bmp_header) + row * img->height,
            .bfReserved = H_RESERVED,
            .biSize = H_SIZE,
            .biPlanes = H_PLANES,
            .biBitCount = H_BIT_COUNT,
            .biCompression = H_COMPRESSION,
            .biXPelsPerMeter = X_PELS_PER_METER,
            .biYPelsPerMeter = Y_PELS_PER_METER,
            .biClrUsed = CLR_USED,
            .biClrImportant = CLR_IMPORTANT

    };


    // пишем в память структуру header
    if (fwrite(&header, sizeof(struct bmp_header), 1, output) != 1) {
        return W_HEADER_ERR;
    }

    // пишем в память изображение
    for (size_t i = 0; i < img->height; i++) {
        // основные данные
        if (!fwrite(img->data + i * img->width, sizeof(struct pixel), img->width, output)) {
            return W_IMG_ERR;
        }
        fseek(output, additional_characters_to_four, SEEK_CUR);
    }

    return W_OK;
}


enum read_code from_bmp(FILE* input, struct image* img) {
    struct bmp_header header;

    if (fread(&header, sizeof(struct bmp_header), 1, input) != 1)
    {
        return R_INVALID_HEADER;
    }

    if (header.bfType != H_TYPE)
    {
        return R_INVALID_SIGNATURE;
    }
    if (header.biBitCount != H_BIT_COUNT)
    {
        return R_INVALID_BIT_COUNT;
    }

    const uint8_t add_chars_to_four = get_num_add_bytes(header.biWidth);

    printf("%d %d %d\n", header.biWidth, header.biHeight, add_chars_to_four);

    *img = make_img(header.biWidth, header.biHeight);
    if (!img->data) return MEMORY_ERROR;

    for (size_t i = 0; i < img->height; i++) {
        if (!fread(img->data + i * img->width, sizeof(struct pixel), img->width, input))
        {
            return R_ERR;
        }

        fseek(input, add_chars_to_four, SEEK_CUR);
    }

    // очищаем header, он больше не нужен
    //free(header);
    return R_OK;
}
