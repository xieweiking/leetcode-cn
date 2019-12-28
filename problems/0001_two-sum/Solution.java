import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> m = new HashMap<>(nums.length + 1, 0.99f);
        for (int i = 0; i < nums.length; ++i) {
            final int num = nums[i];
            final Integer j = m.get(target - num);
            if (j != null)
                return new int[] { j, i };
            m.put(num, i);
        }
        throw new RuntimeException(String.format("No match value for %s, %d!",
                                                 Arrays.toString(nums), target));
    }
}
