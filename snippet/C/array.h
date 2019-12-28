#define MAKE_ARRAY(returnSize, T, ...) ({  \
    const T tmp[] = { ##__VA_ARGS__ };     \
    const int bytes = sizeof(tmp),         \
              n = bytes / sizeof(T);       \
    *returnSize = n;                       \
    T* r = malloc(bytes);                  \
    for (int i = 0; i < n; ++i)            \
        *(r + i) = tmp[i];                 \
    r;                                     \
})

#define INT_ARRAY(returnSize, ...) MAKE_ARRAY(returnSize, int, ##__VA_ARGS__)
