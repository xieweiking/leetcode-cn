object Solution {
    def longestPalindrome(s: String): String = {
        var (maxLeft, maxRight) = (0, 0)
        for (i <- 0 until s.size * 2 - 1) {
            var posLeft = i / 2
            var posRight = if (i % 2 == 1) posLeft + 1 else posLeft
            while (0 <= posLeft && posRight < s.size &&
                    s(posLeft) == s(posRight)) {
                posLeft -= 1
                posRight += 1
            }
            posLeft += 1
            if (posRight - posLeft > maxRight - maxLeft) {
                maxLeft = posLeft
                maxRight = posRight
            }
        }
        s.substring(maxLeft, maxRight)
    }
}
