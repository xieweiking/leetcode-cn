function lengthOfLongestSubstring(s: string): number {
    const map: { [index: string]: number } = {}
    let max = 0
    for (let start = 0, end = 0; end < s.length;) {
        const c = s[end],
              idx = map[c]
        map[c] = end++
        if (idx === undefined || idx < start)
            max = Math.max(max, end - start)
        else
            start = idx + 1
    }
    return max
};
