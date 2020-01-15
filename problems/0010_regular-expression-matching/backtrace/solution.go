func isMatch(s string, p string) bool {
    sLen, pLen := len(s), len(p)
    if pLen == 0 {
        return (sLen == 0)
    }
    p0 := p[0]
    matchP0 := (sLen > 0 &&
            (p0 == s[0] || p0 == '.'))
    if pLen >= 2 && p[1] == '*' {
        return (isMatch(s, p[2:]) ||
                (matchP0 && isMatch(s[1:], p)))
    } else {
        return (matchP0 && isMatch(s[1:], p[1:]))
    }
}
