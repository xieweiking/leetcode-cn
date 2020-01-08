func longestPalindrome(s string) string {
    sLen := len(s)
    if sLen <= 1 {
        return s
    }
    size := 2 * sLen + 1
    t, runes := make([]rune, size), []rune(s)
    for i := 0; i < sLen; i += 1 {
        t[2 * i + 1] = runes[i]
    }
    pLens := make([]int, size)
    c, r, maxPLen, idx := 0, 0, 0, 0
    for i := 0; i < size; i++ {
        j := 2 * c - i
        pLen := 0
        if r > i {
            pLenMax := r - i
            if pLenMax < pLens[j] {
                pLen = pLenMax
            } else {
                pLen = pLens[j]
            }
        }
        for posLeft, posRight := i - (pLen + 1), i + (pLen + 1);
                0 <= posLeft && posRight < size &&
                    t[posLeft] == t[posRight]; {
            pLen++
            posLeft--
            posRight++
        }
        pLens[i] = pLen
        newR := i + pLen
        if newR > r {
            c, r = i, newR
        }
        if pLen > maxPLen {
            maxPLen, idx = pLen, i
        }
    }
    t, pLens = nil, nil
    start := (idx - maxPLen) / 2
    return s[start:start + maxPLen]
}
