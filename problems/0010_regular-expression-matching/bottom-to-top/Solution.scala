object Solution {
    def isMatch(s: String, p: String): Boolean = {
        val memo = Array.ofDim[Boolean](s.length + 1, p.length + 1)
        memo(s.length)(p.length) = true
        for (i <- s.length to 0 by -1)
            for (j <- p.length - 1 to 0 by -1) {
                val matchChar = (i < s.length &&
                        (p(j) == s(i) || p(j) == '.'))
                memo(i)(j) = if (j < p.length - 1 && p(j + 1) == '*')
                            (memo(i)(j + 2) || (matchChar && memo(i + 1)(j)))
                        else
                            (matchChar && memo(i + 1)(j + 1))
            }
        memo(0)(0)
    }
}
