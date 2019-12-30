class Solution {
    func lengthOfLongestSubstring(_ s: String) -> Int {
        var map = [CChar : Int]()
        let chars = s.utf8CString
        var (m, start, end) = (0, 0, 0)
        while end < s.length {
            let c = chars[end]
            let idx = map[c]
            map[c] = end
            end += 1
            if idx == nil || idx! < start {
                m = max(m, end - start)
            } else {
                start = idx! + 1
            }
        }
        return m
    }
}
