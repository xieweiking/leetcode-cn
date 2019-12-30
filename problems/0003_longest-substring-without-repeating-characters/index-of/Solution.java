class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int start = 0, end = 0; end < s.length();) {
            final int idx = indexOf(s, s.charAt(end), start, end++);
            if (idx == -1)
                max = Math.max(max, end - start);
            else
                start = idx + 1;
        }
        return max;
    }
    static int indexOf(final String s, final char c, final int start, final int end) {
        for (int i = start; i < end; ++i)
            if (s.charAt(i) == c)
                return i;
        return -1;
    }
}
