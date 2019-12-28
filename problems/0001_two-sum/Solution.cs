public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var m = new Dictionary<int, int>(nums.Length + 1);
        for (int i = 0; i < nums.Length; ++i) {
            var num = nums[i];
            var r = target - num;
            if (m.ContainsKey(r))
                return new int[] { m[r], i };
            m[num] = i;
        }
        throw new System.Exception($"No match value for {nums}, {target}!");
    }
}
