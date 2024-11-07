#include "validation.h"


struct data validate(char** argv) {

    FILE* input = fopen(argv[1], "rb");

    if (input == NULL) {
        return (struct data) { .status =  INVALID_OPEN };
    }

    FILE* output = fopen(argv[2], "wb");
    if (output == NULL) {
        return (struct data) { .status =  INVALID_OPEN };
    }

    char* value = argv[3];

    if (strcmp(value, "none") != 0  && strcmp(value, "cw90") != 0 && strcmp(value, "fliph") != 0 && strcmp(value, "ccw90") != 0 && strcmp(value, "flipv") != 0) {
        return (struct data) { .status =  INVALID_ARGS };
    }

    return (struct data) {
            .status = OK,
            .input = input,
            .output = output,
            .value = value,
    };
}

const char *err_msg[] = {
    "OK\n",
    "неверный запуск приложения (диапазон значений: none, cw90, ccw90, fliph, flipv). Пример запуска: ./image-transform in.png out.png flipv\n",
    "ошибка при открытии файла, возможно начального файла не существует. Перепроверьте параметры запуска\n",
    "ошибка при закрытии файла\n",
    "ошибка при чтении из файла\n",
    "ошибка при записи в файл\n"
};

enum code print_err(enum code status) {
    printf("Error: %s", err_msg[status]);
    if (status == ERROR_READING) {status=ENOMEM;}
    return status;
}

enum code close_file(FILE* file) {
    if (fclose(file) != 0) {
        return print_err(INVALID_CLOSE);
    }
    return OK;
}
