#define SUB_STR_PTR(s, start, len) ({                \
    char* __ss__ = malloc((len + 1) * sizeof(char)); \
    memcpy(__ss__, &s[start], len);                  \
    __ss__[len] = '\0';                              \
    __ss__;                                          \
})

#define SUB_STR_ARY(s, start, len) ({ \
    char __ss__[len + 1];             \
    memcpy(__ss__, &s[start], len);   \
    __ss__[len] = '\0';               \
    __ss__;                           \
})
