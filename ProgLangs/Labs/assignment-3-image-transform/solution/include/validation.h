#ifndef VALIDATION_H
#define VALIDATION_H

#include <errno.h>
#include <stdio.h>
#include <string.h>

enum code {
    OK = 0,
    INVALID_ARGS,
    INVALID_OPEN,
    INVALID_CLOSE,
    ERROR_READING,
    ERROR_SAVING
};

struct data {
    enum code status;
    FILE* input;
    FILE* output;
    char *value;
};

struct data validate(char** argv);


enum code print_err(enum code status);

enum code close_file(FILE* file);

#endif 
