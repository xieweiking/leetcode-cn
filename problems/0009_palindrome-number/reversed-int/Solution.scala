object Solution {
    def isPalindrome(x: Int): Boolean = {
        if (x < 0)
            return false
        else if (x < 10)
            return true
        var (reversed, k) = (0, x)
        while (k != 0) {
            reversed = reversed * 10 + (k % 10)
            k /= 10
        }
        x == reversed
    }
}
