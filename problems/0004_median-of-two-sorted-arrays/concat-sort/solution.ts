function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const nums = nums1.concat(...nums2).sort((l, r) => l - r),
        i = Math.floor(nums.length / 2)
    return (nums.length % 2 === 0 ? (nums[i - 1] + nums[i]) / 2 : nums[i])
};
