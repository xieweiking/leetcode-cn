import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] nums = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        final int i = nums.length / 2;
        return (nums.length % 2 == 0 ? (nums[i - 1] + nums[i]) / 2.0 : nums[i]);
    }
}
