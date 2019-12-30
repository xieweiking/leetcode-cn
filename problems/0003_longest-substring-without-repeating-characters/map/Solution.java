import java.util.Map;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        final Map<Character, Integer> map = new HashMap<>(256);
        int max = 0;
        for (int start = 0, end = 0; end < s.length();) {
            final char c = s.charAt(end);
            final Integer idx = map.get(c);
            map.put(c, end++);
            if (idx == null || idx < start)
                max = Math.max(max, end - start);
            else
                start = idx + 1;
        }
        return max;
    }
}
