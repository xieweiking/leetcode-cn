class Solution {
    func longestPalindrome(_ s: String) -> String {
        let (chars, sLen) = (s.utf8CString, s.count)
        var (maxLeft, maxRight) = (0, 0)
        for i in 0...(sLen * 2) {
            var posLeft = i / 2
            var posRight = (i % 2 == 1 ? posLeft + 1 : posLeft)
            while 0 <= posLeft && posRight < sLen &&
                    chars[posLeft] == chars[posRight] {
                posLeft -= 1
                posRight += 1
            }
            posLeft += 1
            if posRight - posLeft > maxRight - maxLeft {
                (maxLeft, maxRight) = (posLeft, posRight)
            }
        }
        return substring(s, maxLeft, maxRight)
    }
    @inline
    func substring(_ s: String, _ start: Int, _ end: Int) -> String {
        return String(s[s.index(s.startIndex, offsetBy: start)..<s.index(s.startIndex, offsetBy: end)])
    }
}
