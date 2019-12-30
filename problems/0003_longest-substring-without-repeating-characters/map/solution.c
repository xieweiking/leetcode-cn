int lengthOfLongestSubstring(char * s) {
    int map[] = { [0 ... 255] = -1 };
    int max = 0, start = 0, end = 0;
    for (char c = *s; c != '\0'; c = *(s + end)) {
        const int idx = map[c];
        map[c] = end++;
        if (idx == -1 || idx < start) {
            const int l = end - start;
            if (l > max)
                max = l;
        } else
            start = idx + 1;
    }
    return max;
}
