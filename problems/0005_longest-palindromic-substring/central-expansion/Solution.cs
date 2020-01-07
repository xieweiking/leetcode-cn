public class Solution {
    public string LongestPalindrome(string s) {
        int iEnd = s.Length * 2 - 1,
            start = 0, maxLen = 0;
        for (int i = 0; i < iEnd; ++i) {
            int posLeft = i / 2,
                posRight = (i % 2 == 1 ? posLeft + 1 : posLeft);
            while (0 <= posLeft && posRight < s.Length &&
                    s[posLeft] == s[posRight]) {
                --posLeft;
                ++posRight;
            }
            int len = posRight - (++posLeft);
            if (len > maxLen) {
                start = posLeft;
                maxLen = len;
            }
        }
        return s.Substring(start, maxLen);
    }
}
