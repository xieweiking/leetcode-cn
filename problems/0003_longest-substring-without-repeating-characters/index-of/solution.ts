function lengthOfLongestSubstring(s: string): number {
    function indexOf(c: string, start: number, end: number) {
        for (let i = start; i < end; ++i)
            if (s[i] === c)
                return i
    }
    let max = 0
    for (let start = 0, end = 0; end < s.length;) {
        const idx = indexOf(s[end], start, end++)
        if (idx === undefined)
            max = Math.max(max, end - start)
        else
            start = idx + 1
    }
    return max
};
