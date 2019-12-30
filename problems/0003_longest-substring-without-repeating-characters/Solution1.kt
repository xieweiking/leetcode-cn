class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var start = 0
        var end = 0
        s.forEach { c ->
            val idx = find(s, c, start, end)
            ++end
            if (idx == -1)
                max = Math.max(max, end - start)
            else
                start = idx + 1
        }
        return max
    }
    inline fun find(s: String, c: Char, start: Int, end: Int): Int {
        for (i in start..(end - 1))
            if (s[i] == c)
                return i
        return -1
    }
}
