func isMatch(s string, p string) bool {
    sLen, pLen := len(s), len(p)
    memo := make([][]bool, sLen + 1)
    for i := range memo {
        memo[i] = make([]bool, pLen + 1)
    }
    memo[sLen][pLen] = true
    for i := sLen; i >= 0; i-- {
        for j := pLen - 1; j >= 0; j-- {
            matchChar := (i < sLen &&
                    (p[j] == s[i] || p[j] == '.'))
            if j < pLen - 1 && p[j + 1] == '*' {
                memo[i][j] = (memo[i][j + 2] || (matchChar && memo[i + 1][j]))
            } else {
                memo[i][j] = (matchChar && memo[i + 1][j + 1])
            }
        }
    }
    return memo[0][0]
}
