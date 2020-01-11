class Solution {
    public int myAtoi(String str) {
        final int sLen = str.length();
        if (sLen == 0)
            return 0;
        int i = 0;
        for (; i < sLen && str.charAt(i) == ' '; ++i);
        long sign = 1;
        if (i < sLen)
            if (str.charAt(i) == '-') {
                ++i;
                sign = -1;
            } else if (str.charAt(i) == '+') {
                ++i;
            }
        long result = 0;
        for (; i < sLen && '0' <= str.charAt(i) && str.charAt(i) <= '9'; ++i) {
            result = result * 10 + sign * (str.charAt(i) - '0');
            if (result < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else if (result > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return (int) result;
    }
}
