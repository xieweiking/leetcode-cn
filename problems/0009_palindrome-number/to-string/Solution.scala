object Solution {
    def isPalindrome(x: Int): Boolean = {
        if (x < 0)
            return false
        else if (x < 10)
            return true
        val s = x.toString
        var (i, j) = (0, s.length - 1)
        while (i < j) {
            if (s(i) != s(j))
                return false
            i += 1
            j -= 1
        }
        true
    }
}
