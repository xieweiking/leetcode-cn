object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var (max, start, end) = (0, 0, 0)
        for (c <- s) {
            val idx = find(s, c, start, end)
            end += 1
            if (idx == -1)
                max = (end - start).max(max)
            else
                start = idx + 1
        }
        max
    }
    @inline
    def find(s: String, c: Char, start: Int, end: Int): Int = {
        for (i <- start until end)
            if (s(i) == c)
                return i
        return -1
    }
}
