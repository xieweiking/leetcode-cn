public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        var nums = new int[nums1.Length + nums2.Length];
        Array.Copy(nums1, 0, nums, 0, nums1.Length);
        Array.Copy(nums2, 0, nums, nums1.Length, nums2.Length);
        Array.Sort(nums);
        var i = nums.Length / 2;
        return (nums.Length % 2 == 0 ? (nums[i - 1] + nums[i]) / 2.0 : nums[i]);
    }
}
