class Solution {
    func longestPalindrome(_ s: String) -> String {
        let sLen = s.count
        if sLen <= 1 {
            return s
        }
        let (chars, size) = (s.utf8CString, 2 * sLen + 1)
        var t = [CChar](repeating: 0, count: size)
        for i in 0..<sLen {
            t[2 * i + 1] = chars[i]
        }
        var pLens = [Int](repeating: 0, count: size)
        var (c, r, maxPLen, idx) = (0, 0, 0, 0)
        for i in 0..<size {
            let j = 2 * c - i
            var pLen = (r > i ?
                    min(r - i, pLens[j]) : 0)
            var (posLeft, posRight) = (i - (pLen + 1), i + (pLen + 1))
            while 0 <= posLeft && posRight < size &&
                    t[posLeft] == t[posRight] {
                pLen += 1
                posLeft -= 1
                posRight += 1
            }
            pLens[i] = pLen
            let newR = i + pLen
            if newR > r {
                (c, r) = (i, newR)
            }
            if pLen > maxPLen {
                (maxPLen, idx) = (pLen, i)
            }
        }
        let start = (idx - maxPLen) / 2
        return substring(s, start, start + maxPLen)
    }
    @inline
    func substring(_ s: String, _ start: Int, _ end: Int) -> String {
        return String(s[s.index(s.startIndex, offsetBy: start)..<s.index(s.startIndex, offsetBy: end)])
    }
}
