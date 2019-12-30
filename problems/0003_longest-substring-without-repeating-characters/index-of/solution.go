func lengthOfLongestSubstring(s string) int {
    max, l := 0, len(s)
    for start, end := 0, 0; end < l; {
        idx := indexOf(s, s[end], start, end)
        end += 1
        if idx == -1 {
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

func indexOf(s string, c byte, start, end int) int {
    for i := start; i < end; i += 1 {
        if s[i] == c {
            return i
        }
    }
    return -1
}
