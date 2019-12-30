#!/usr/bin/python3

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        d = {}
        m, start, end = 0, 0, 0
        for c in s:
            idx = d.get(c)
            d[c] = end
            end += 1
            if idx is None or idx < start:
                m = max(m, end - start)
            else:
                start = idx + 1
        return m
