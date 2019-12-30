#!/usr/bin/python3

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m, start, end = 0, 0, 0
        for c in s:
            idx = s.find(c, start, end)
            end += 1
            if idx == -1:
                m = max(m, end - start)
            else:
                start = idx + 1
        return m
