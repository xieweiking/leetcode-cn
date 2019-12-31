#!/usr/bin/python3

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        nums = nums1 + nums2
        nums.sort()
        size = len(nums)
        i = size // 2
        return (nums[i - 1] + nums[i]) / 2 if size % 2 == 0 else nums[i]
