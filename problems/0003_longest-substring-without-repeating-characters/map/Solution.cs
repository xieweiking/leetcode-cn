public class Solution {
    public int LengthOfLongestSubstring(string s) {
        var map = new Dictionary<char, int>(256);
        int max = 0, start = 0, end = 0;
        foreach (char c in s) {
            int idx;
            if (!map.TryGetValue(c, out idx))
                idx = -1;
            map[c] = end++;
            if (idx == -1 || idx < start)
                max = Math.Max(max, end - start);
            else
                start = idx + 1;
        }
        return max;
    }
}
