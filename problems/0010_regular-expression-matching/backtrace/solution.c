bool isMatch(char * s, char * p) {
    const char p0 = p[0], s0 = s[0];
    const bool sIsEmpty = (s0 == '\0'),
               pIsEmpty = (p0 == '\0');
    if (pIsEmpty)
        return sIsEmpty;
    const bool matchP0 = (!sIsEmpty &&
            (p0 == s0 || p0 == '.'));
    if (p[1] != '\0' && p[1] == '*')
        return (isMatch(s, p + 2) ||
                (matchP0 && isMatch(s + 1, p)));
    else
        return (matchP0 && isMatch(s + 1, p + 1));
}
