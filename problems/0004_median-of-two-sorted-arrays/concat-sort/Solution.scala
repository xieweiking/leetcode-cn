object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val nums = (nums1 ++ nums2).sorted
        val i = nums.size / 2
        if (nums.size % 2 == 0)
            (nums(i - 1) + nums(i)) / 2.0
        else
            nums(i)
    }
}
