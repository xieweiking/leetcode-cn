function longestPalindrome(s: string): string {
    if (s.length <= 1)
        return s
    const sep = '#',
        t = sep + [...s].join(sep) + sep,
        pLens = new Array(t.length)
    let c = 0, r = 0, maxPLen = 0, idx = 0
    for (const i of pLens.keys()) {
        const j = 2 * c - i
        let pLen = (r > i ?
                Math.min(r - i, pLens[j]) : 0)
        for (let incrPLen = pLen + 1,
                posLeft = i - incrPLen,
                posRight = i + incrPLen;
                0 <= posLeft && posRight < t.length &&
                    t[posLeft] === t[posRight];
                --posLeft, ++posRight)
            ++pLen
        const newR = i + (pLens[i] = pLen)
        if (newR > r)
            [c, r] = [i, newR]
        if (pLen > maxPLen)
            [maxPLen, idx] = [pLen, i]
    }
    const start = (idx - maxPLen) >> 1
    return s.substring(start, start + maxPLen)
};
