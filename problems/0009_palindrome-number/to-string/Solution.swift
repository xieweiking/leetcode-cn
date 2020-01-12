class Solution {
    func isPalindrome(_ x: Int) -> Bool {
        if x < 0 {
            return false
        } else if x < 10 {
            return true
        }
        let chars = Array(String(x))
        var (i, j) = (0, chars.count - 1)
        while i < j {
            if chars[i] != chars[j] {
                return false
            }
            i += 1
            j -= 1
        }
        return true
    }
}
