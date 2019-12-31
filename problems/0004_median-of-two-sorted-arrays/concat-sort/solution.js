/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    'use strict'
    const nums = nums1.concat(...nums2).sort((l, r) => l - r),
          i = parseInt(nums.length / 2)
    return (nums.length % 2 === 0 ? (nums[i - 1] + nums[i]) / 2 : nums[i])
};
