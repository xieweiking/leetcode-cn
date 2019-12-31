#!/usr/bin/ruby

# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)
    nums = nums1.concat(nums2)
    nums.sort!
    i = nums.length / 2
    return (nums.length % 2 == 0 ? (nums[i - 1] + nums[i]) / 2.0 : nums[i])
end
