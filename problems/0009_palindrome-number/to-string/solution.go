import "strconv"

func isPalindrome(x int) bool {
    if x < 0 {
        return false
    } else if x < 10 {
        return true
    }
    s := strconv.Itoa(x)
    i, j := 0, len(s) - 1
    for i < j {
        if s[i] != s[j] {
            return false
        }
        i++
        j--
    }
    return true
}
