class Solution {
    fun isMatch(s: String, p: String): Boolean {
        val memo = Array(s.length + 1) { Array(p.length + 1) { false } }
        memo[s.length][p.length] = true
        for (i in s.length downTo 0)
            for (j in p.length - 1 downTo 0) {
                val matchChar = (i < s.length &&
                        (p[j] == s[i] || p[j] == '.'))
                memo[i][j] = if (j < p.length - 1 && p[j + 1] == '*')
                            (memo[i][j + 2] || (matchChar && memo[i + 1][j]))
                        else
                            (matchChar && memo[i + 1][j + 1])
            }
        return memo[0][0]
    }
}
