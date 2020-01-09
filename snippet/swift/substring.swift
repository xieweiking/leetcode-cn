@inline
func substring(_ s: String, _ start: Int, _ end: Int) -> String {
    return String(s[s.index(s.startIndex, offsetBy: start)..<s.index(s.startIndex, offsetBy: end)])
}
