#define SUB_STR_PTR(s, start, len) ({                \
    char* __ss__ = malloc((len + 1) * sizeof(char)); \
    memcpy(__ss__, &s[start], len);                  \
    __ss__[len] = '\0';                              \
    __ss__;                                          \
})

#define MIN(X,Y) ((X) < (Y) ? (X) : (Y))

char* longestPalindrome(char* s){
    const int sLen = strlen(s);
    if (sLen <= 1)
        return s;
    const int size = 2 * sLen + 1;
    char t[size];
    for (int i = 0; i < sLen; ++i) {
        const int j = 2 * i;
        t[j] = '\0';
        t[j + 1] = s[i];
    }
    t[size - 1] = '\0';
    int pLens[size], c = 0, r = 0, maxPLen = 0, idx = 0;
    for (int i = 0; i < size; ++i) {
        const int j = 2 * c - i;
        int pLen = (r > i ?
                MIN(r - i, pLens[j]) : 0);
        for (int incrPLen = pLen + 1,
                 posLeft = i - incrPLen,
                 posRight = i + incrPLen;
                0 <= posLeft && posRight < size &&
                    t[posLeft] == t[posRight];
                --posLeft, ++posRight)
            ++pLen;
        const int newR = i + (pLens[i] = pLen);
        if (newR > r) {
            c = i;
            r = newR;
        }
        if (pLen > maxPLen) {
            maxPLen = pLen;
            idx = i;
        }
    }
    const int start = (idx - maxPLen) / 2;
    return SUB_STR_PTR(s, start, maxPLen);
}
