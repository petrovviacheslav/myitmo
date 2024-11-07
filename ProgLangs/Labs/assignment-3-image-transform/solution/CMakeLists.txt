file(GLOB_RECURSE sources CONFIGURE_DEPENDS
    src/*.c
    src/*.h
    include/*.h
)

add_executable(image-transform ${sources})
target_include_directories(image-transform PRIVATE src include)
