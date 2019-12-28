#!/usr/bin/python3

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {};
        for i, num in enumerate(nums):
            r = target - num;
            if r in m:
                return [m[r], i];
            m[num] = i;
        raise Exception(f"No match value for {nums}, {target}!");
