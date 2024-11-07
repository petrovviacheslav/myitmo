#include <stdio.h>

#include "handler.h"
#include "rotate.h"
#include "validation.h"

int main(const int arg_count, char** argv) {

    if (arg_count < 4) return print_err(INVALID_ARGS);

    // валидируем полученные данные и выкидываем с ошибкой, если что-то не так
    struct data input = validate(argv);
    if (input.status != OK) return print_err(input.status);

    printf("The validation was successful\n");

    printf("Processing of input file...\n");

    // код возврата
    enum code exit_code;

    // read code
    struct image start_img;
    enum read_code rc = from_bmp(input.input, &start_img);

    if (rc != R_OK) {
        close_file(input.input);
        exit_code = print_err(ERROR_READING);
    }
    else exit_code = close_file(input.input);

    if (exit_code == OK) printf("The reading was successful\n");
    else return exit_code;


    // меняем изображение
    struct image end_image;
    end_image = rotate(&start_img, input.value);
    printf("The rotating was successful\n");

    printf("Processing of output file...\n");
    enum write_code wc = to_bmp(input.output, &end_image);
    
    if (wc != W_OK) {
        close_file(input.output);
        exit_code = print_err(ERROR_SAVING);
    }
    else exit_code = close_file(input.output);

    kill_img(&end_image);

    if (exit_code == OK) printf("The saving was successful\n");
    return exit_code;
}
