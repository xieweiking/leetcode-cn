class Solution {
public:
    string longestPalindrome(string s) {
        const int sLen = s.length(),
                  iEnd = sLen * 2 - 1;
        int start = 0, maxLen = 0;
        for (int i = 0; i < iEnd; ++i) {
            int posLeft = i / 2,
                posRight = (i % 2 == 1 ? posLeft + 1 : posLeft);
            while (0 <= posLeft && posRight < sLen &&
                    s[posLeft] == s[posRight]) {
                --posLeft;
                ++posRight;
            }
            const int len = posRight - (++posLeft);
            if (len > maxLen) {
                start = posLeft;
                maxLen = len;
            }
        }
        return s.substr(start, maxLen);
    }
};
