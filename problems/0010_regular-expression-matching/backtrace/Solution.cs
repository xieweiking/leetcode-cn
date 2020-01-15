public class Solution {
    public bool IsMatch(string s, string p) {
        if (p.Length == 0)
            return (s.Length == 0);
        var p0 = p[0];
        var matchP0 = (s.Length > 0 &&
                (p0 == s[0] || p0 == '.'));
        if (p.Length >= 2 && p[1] == '*')
            return (IsMatch(s, p.Substring(2)) ||
                    (matchP0 && IsMatch(s.Substring(1), p)));
        else
            return (matchP0 && IsMatch(s.Substring(1), p.Substring(1)));
    }
}
