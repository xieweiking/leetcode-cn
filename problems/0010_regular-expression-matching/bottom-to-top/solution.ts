function isMatch(s: string, p: string): boolean {
    const memo = new Array<Array<boolean>>(s.length + 1)
    for (let i = 0; i < memo.length; ++i)
        memo[i] = new Array<boolean>(p.length + 1)
    memo[s.length][p.length] = true
    for (let i = s.length; i >= 0; --i)
        for (let j = p.length - 1; j >= 0; --j) {
            const matchChar = (i < s.length &&
                    (p[j] === s[i] || p[j] === '.'))
            memo[i][j] = (j < p.length - 1 && p[j + 1] === '*' ?
                    (memo[i][j + 2] || (matchChar && memo[i + 1][j])) :
                    (matchChar && memo[i + 1][j + 1]))
        }
    return Boolean(memo[0][0])
};
