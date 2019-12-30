class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        let chars = s.utf8CString
        var (m, start, end) = (0, 0, 0)
        while end < s.length {
            let idx = indexOf(chars, chars[end], start, end)
            end += 1
            if idx == nil {
                m = max(m, end - start)
            } else {
                start = idx! + 1
            }
        }
        return m
    }
    @inline(__always)
    func indexOf(_ chars: ContiguousArray<CChar>, _ c: CChar, _ start: Int, _ end: Int) -> Int? {
        for i in start..<end {
            if chars[i] == c {
                return i
            }
        }
        return nil
    }
}
