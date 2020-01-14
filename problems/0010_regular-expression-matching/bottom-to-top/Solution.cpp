class Solution {
public:
    bool isMatch(string s, string p) {
        const int sLen = s.length(), pLen = p.length();
        bool memo[sLen + 1][pLen + 1];
        memset(&memo[0][0], false, sizeof(memo));
        memo[sLen][pLen] = true;
        for (int i = sLen; i >= 0; --i)
            for (int j = pLen - 1; j >= 0; --j) {
                const bool matchChar = (i < sLen &&
                        (p[j] == s[i] || p[j] == '.'));
                memo[i][j] = (j < pLen - 1 && p[j + 1] == '*' ?
                        (memo[i][j + 2] || (matchChar && memo[i + 1][j])) :
                        (matchChar && memo[i + 1][j + 1]));
            }
        return memo[0][0];
    }
};
