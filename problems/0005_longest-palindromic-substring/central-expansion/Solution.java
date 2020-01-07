class Solution {
    public String longestPalindrome(String s) {
        final int l = s.length(),
                  iEnd = l * 2 - 1;
        int maxLeft = 0, maxRight = 0;
        for (int i = 0; i < iEnd; ++i) {
            int posLeft = i / 2,
                posRight = (i % 2 == 1 ? posLeft + 1 : posLeft);
            while (0 <= posLeft && posRight < l &&
                    s.charAt(posLeft) == s.charAt(posRight)) {
                --posLeft;
                ++posRight;
            }
            if (posRight - (++posLeft) > maxRight - maxLeft) {
                maxLeft = posLeft;
                maxRight = posRight;
            }
        }
        return s.substring(maxLeft, maxRight);
    }
}
