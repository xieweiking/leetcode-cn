inline int find(const char* s, const char c, const int start, const int end) {
    for (int i = start; i < end; ++i)
        if (*(s + i) == c)
            return i;
    return -1;
}

int lengthOfLongestSubstring(char * s){
    int max = 0, start = 0, end = 0, i = 0;
    for (char c = *s; c != '\0'; c = *(s + (++i))) {
        const int idx = find(s, c, start, end);
        ++end;
        if (idx == -1) {
            const int l = end - start;
            if (l > max)
                max = l;
        } else
            start = idx + 1;
    }
    return max;
}
