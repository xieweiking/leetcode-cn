class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0, start = 0, end = 0; i < s.length(); ++i) {
            final int idx = find(s, s.charAt(i), start, end);
            ++end;
            if (idx == -1)
                max = Math.max(max, end - start);
            else
                start = idx + 1;
        }
        return max;
    }
    static int find(final String s, final char c, final int start, final int end) {
        for (int i = start; i < end; ++i)
            if (s.charAt(i) == c)
                return i;
        return -1;
    }
}
