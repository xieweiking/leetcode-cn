func isPalindrome(x int) bool {
    if x < 0 {
        return false
    } else if x < 10 {
        return true
    }
    reversed := 0
    for k := x; k != 0; k /= 10 {
        reversed = reversed * 10 + (k % 10)
    }
    return x == reversed
}
