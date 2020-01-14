public class Solution {
    public bool IsMatch(string s, string p) {
        var memo = new bool[s.Length + 1, p.Length + 1];
        memo[s.Length, p.Length] = true;
        for (var i = s.Length; i >= 0; --i)
            for (var j = p.Length - 1; j >= 0; --j) {
                var matchChar = (i < s.Length &&
                        (p[j] == s[i] || p[j] == '.'));
                memo[i, j] = (j < p.Length - 1 && p[j + 1] == '*' ?
                        (memo[i, j + 2] || (matchChar && memo[i + 1, j])) :
                        (matchChar && memo[i + 1, j + 1]));
            }
        return memo[0, 0];
    }
}
