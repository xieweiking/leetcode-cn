func lengthOfLongestSubstring(s string) int {
    m := make(map[byte]int, 256)
    max, l := 0, len(s)
    for start, end := 0, 0; end < l; {
        c := s[end]
        idx, ok := m[c]
        m[c] = end
        end += 1
        if !ok || idx < start {
            m := end - start
            if m > max {
                max = m
            }
        } else {
            start = idx + 1
        }
    }
    return max
}

