func longestPalindrome(s string) string {
    sLen := len(s)
    iEnd := sLen * 2 - 1
    maxLeft, maxRight := 0, 0
    for i := 0; i < iEnd; i += 1 {
        posLeft := i / 2
        posRight := posLeft
        if i % 2 == 1 {
            posRight += 1
        }
        for 0 <= posLeft && posRight < sLen &&
                s[posLeft] == s[posRight] {
            posLeft -= 1
            posRight += 1
        }
        posLeft += 1
        if posRight - posLeft > maxRight - maxLeft {
            maxLeft, maxRight = posLeft, posRight
        }
    }
    return s[maxLeft:maxRight]
}
