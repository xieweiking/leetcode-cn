class Solution {
    public boolean isMatch(String s, String p) {
        final int sLen = s.length(), pLen = p.length();
        if (pLen == 0)
            return sLen == 0;
        final char p0 = p.charAt(0);
        final boolean matchP0 = (sLen > 0 &&
                (p0 == s.charAt(0) || p0 == '.'));
        if (pLen >= 2 && p.charAt(1) == '*')
            return (isMatch(s, p.substring(2)) ||
                    (matchP0 && isMatch(s.substring(1), p)));
        else
            return (matchP0 && isMatch(s.substring(1), p.substring(1)));
    }
}
