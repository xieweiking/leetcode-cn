class Solution {
    func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
        var nums = nums1 + nums2
        nums.sort()
        let i = nums.count / 2
        return (nums.count % 2 == 0 ? Double(nums[i - 1] + nums[i]) / 2.0 : Double(nums[i]))
    }
}
