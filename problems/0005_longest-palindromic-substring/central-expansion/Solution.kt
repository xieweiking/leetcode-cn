class Solution {
    fun longestPalindrome(s: String): String {
        val iEnd = s.length * 2 - 1
        var maxLeft = 0
        var maxRight = 0
        for (i in 0 until iEnd) {
            var posLeft = i / 2
            var posRight = if (i % 2 == 1) posLeft + 1
                           else posLeft
            while (0 <= posLeft && posRight < s.length &&
                    s[posLeft] == s[posRight]) {
                --posLeft
                ++posRight
            }
            if (posRight - (++posLeft) > maxRight - maxLeft) {
                maxLeft = posLeft
                maxRight = posRight
            }
        }
        return s.substring(maxLeft, maxRight)
    }
}
