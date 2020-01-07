#define SUB_STR_PTR(s, start, len) ({                \
    char* __ss__ = malloc((len + 1) * sizeof(char)); \
    memcpy(__ss__, &s[start], len);                  \
    __ss__[maxLen] = '\0';                           \
    __ss__;                                          \
})
