public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int max = 0, start = 0, end = 0;
        foreach (char c in s) {
            int count = (end++) - start,
                idx = s.IndexOf(c, start, count);
            if (idx == -1)
                max = Math.Max(max, count + 1);
            else
                start = idx + 1;
        }
        return max;
    }
}
