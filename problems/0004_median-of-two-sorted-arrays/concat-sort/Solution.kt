class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums = (nums1 + nums2).sortedArray()
        val i = nums.size / 2
        return if (nums.size % 2 == 0) (nums[i - 1] + nums[i]) / 2.0 else nums[i].toDouble()
    }
}
