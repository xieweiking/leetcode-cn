class Solution {
    func isMatch(_ s: String, _ p: String) -> Bool {
        return (try! NSRegularExpression(pattern: "^\(p)$")).firstMatch(
                in: s, range: NSRange(location: 0, length: s.count)) != nil
    }
}
