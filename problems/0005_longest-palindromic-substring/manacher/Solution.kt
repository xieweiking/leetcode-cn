class Solution {
    fun longestPalindrome(s: String): String {
        if (s.length <= 1)
            return s
        val size = 2 * s.length + 1;
        val t = CharArray(size)
        for (i in 0..(s.length - 1))
            t[2 * i + 1] = s[i]
        val pLens = IntArray(size)
        var c = 0
        var r = 0
        var maxPLen = 0
        var idx = 0
        for (i in 0..(size - 1)) {
            val j = 2 * c - i;
            var pLen = if (r > i) Math.min(r - i, pLens[j])
                       else 0
            var posLeft = i - (pLen + 1)
            var posRight = i + (pLen + 1)
            while (0 <= posLeft && posRight < size &&
                    t[posLeft] == t[posRight]) {
                ++pLen
                --posLeft
                ++posRight
            }
            pLens[i] = pLen
            val newR = i + pLen
            if (newR > r) {
                c = i
                r = newR
            }
            if (pLen > maxPLen) {
                maxPLen = pLen
                idx = i
            }
        }
        val start = (idx - maxPLen) / 2
        return s.substring(start, start + maxPLen)
    }
}
