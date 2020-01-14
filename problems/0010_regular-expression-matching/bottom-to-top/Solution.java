class Solution {
    public boolean isMatch(String s, String p) {
        final int sLen = s.length(), pLen = p.length();
        final boolean[][] memo = new boolean[sLen + 1][pLen + 1];
        memo[sLen][pLen] = true;
        for (int i = sLen; i >= 0; --i)
            for (int j = pLen - 1; j >= 0; --j) {
                final boolean matchChar = (i < sLen &&
                        (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                memo[i][j] = (j < pLen - 1 && p.charAt(j + 1) == '*' ?
                        (memo[i][j + 2] || (matchChar && memo[i + 1][j])) :
                        (matchChar && memo[i + 1][j + 1]));
            }
        return memo[0][0];
    }
}
