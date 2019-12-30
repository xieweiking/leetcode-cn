class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>(256)
        var max = 0
        var start = 0
        var end = 0
        s.forEach { c ->
            val idx = map[c]
            map[c] = end++
            if (idx == null || idx < start)
                max = Math.max(max, end - start)
            else
                start = idx + 1
        }
        return max
    }
}
