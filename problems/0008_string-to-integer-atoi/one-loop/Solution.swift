class Solution {
    func myAtoi(_ str: String) -> Int {
        if str.count == 0 {
            return 0
        }
        let chars = Array(str)
        var i = 0
        while i < str.count && chars[i] == " " {
            i += 1
        }
        var sign = 1
        if i < str.count {
            if chars[i] == "-" {
                i += 1
                sign = -1
            } else if chars[i] == "+" {
                i += 1
            }
        }
        var result = 0
        while i < str.count && "0" <= chars[i] && chars[i] <= "9" {
            result = result * 10 + sign * Int(chars[i].asciiValue! - 48)
            if result < INT_MIN {
                return INT_MIN
            } else if result > INT_MAX {
                return INT_MAX
            }
            i += 1
        }
        return result
    }
    let (INT_MIN, INT_MAX) = (Int(Int32.min), Int(Int32.max))
}
