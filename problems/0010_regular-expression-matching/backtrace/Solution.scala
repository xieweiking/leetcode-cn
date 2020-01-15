object Solution {
    def isMatch(s: String, p: String): Boolean = {
        if (p isEmpty) return (s isEmpty)
        val p0 = p(0)
        val matchP0 = (!s.isEmpty &&
                (p0 == s(0) || p0 == '.'))
        if (p.length >= 2 && p(1) == '*')
            return (isMatch(s, p.substring(2)) ||
                    (matchP0 && isMatch(s.substring(1), p)))
        else
            return (matchP0 && isMatch(s.substring(1), p.substring(1)))
    }
}
