object Solution {
    def longestPalindrome(s: String): String = {
        if (s.size <= 1)
            return s
        val size = 2 * s.size + 1
        val t = new Array[Char](size)
        for (i <- 0 until s.size)
            t(2 * i + 1) = s(i)
        val pLens = new Array[Int](size)
        var (c, r, maxPLen, idx) = (0, 0, 0, 0)
        for (i <- 0 until size) {
            val j = 2 * c - i
            var pLen = if (r > i) pLens(j).min(r - i)
                       else 0
            val incrPLen = pLen + 1
            var (posLeft, posRight) = (i - incrPLen, i + incrPLen)
            while (0 <= posLeft && posRight < t.size &&
                    t(posLeft) == t(posRight)) {
                pLen += 1
                posLeft -= 1
                posRight += 1
            }
            pLens(i) = pLen
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
        s.substring(start, start + maxPLen)
    }
}
