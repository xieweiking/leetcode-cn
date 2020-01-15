class Solution {
public:
    bool isMatch(string s, string p) {
        const int sLen = s.length(), pLen = p.length();
        if (pLen == 0)
            return (sLen == 0);
        const char p0 = p[0];
        const bool matchP0 = (sLen > 0 &&
                (p0 == s[0] || p0 == '.'));
        if (pLen >= 2 && p[1] == '*')
            return (isMatch(s, p.substr(2)) ||
                    (matchP0 && isMatch(s.substr(1), p)));
        else
            return (matchP0 && isMatch(s.substr(1), p.substr(1)));
    }
};
