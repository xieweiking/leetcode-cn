func lengthOfLongestSubstring(s string) int {
    max, l := 0, len(s)
    for i, start, end := 0, 0, 0; i < l; i += 1 {
        idx := find(s, s[i], start, end)
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

func find(s string, c byte, start, end int) int {
    for i := start; i < end; i += 1 {
        if s[i] == c {
            return i
        }
    }
    return -1
}
