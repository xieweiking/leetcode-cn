class Solution {
    func isMatch(_ s: String, _ p: String) -> Bool {
        return _isMatch(Array(s), Array(p))
    }
    func _isMatch(_ s: [Character], _ p: [Character]) -> Bool {
        if p.count == 0 {
            return (s.count == 0)
        }
        let p0 = p[0]
        let matchP0 = (s.count > 0 &&
                (p0 == s[0] || p0 == "."))
        if p.count >= 2 && p[1] == "*" {
            return (_isMatch(s, Array(p[2..<p.count])) ||
                    (matchP0 && _isMatch(Array(s[1..<s.count]), p)))
        } else {
            return (matchP0 && _isMatch(Array(s[1..<s.count]), Array(p[1..<p.count])))
        }
    }
}
