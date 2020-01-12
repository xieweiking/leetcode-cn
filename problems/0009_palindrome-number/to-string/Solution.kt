class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x < 0)
            return false
        else if (x < 10)
            return true
        val s = x.toString()
        var i = 0
        var j = s.length - 1
        while (i < j)
            if (s[i++] != s[j--])
                return false
        return true
    }
}
