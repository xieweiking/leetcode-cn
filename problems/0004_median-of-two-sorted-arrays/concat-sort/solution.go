func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    nums := []int{}
    nums = append(nums1, nums2...)
    sort.Ints(nums)
    size := len(nums)
    i := size / 2
    if size % 2 == 0 {
        return float64(nums[i - 1] + nums[i]) / 2.0
    } else {
        return float64(nums[i])
    }
}
