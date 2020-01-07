#define SUB_STR_PTR(s, start, len) ({                \
    char* __ss__ = malloc((len + 1) * sizeof(char)); \
    memcpy(__ss__, &s[start], len);                  \
    __ss__[len] = '\0';                              \
    __ss__;                                          \
})

char* longestPalindrome(char* s){
    const int sLen = strlen(s),
              iEnd = sLen * 2 - 1;
    int start = 0, maxLen = 0;
    for (int i = 0; i < iEnd; ++i) {
        int posLeft = i / 2,
            posRight = (i % 2 == 1 ? posLeft + 1 : posLeft);
        while (0 <= posLeft && posRight < sLen &&
                s[posLeft] == s[posRight]) {
            --posLeft;
            ++posRight;
        }
        const int len = posRight - (++posLeft);
        if (len > maxLen) {
            start = posLeft;
            maxLen = len;
        }
    }
    return SUB_STR_PTR(s, start, maxLen);
}
