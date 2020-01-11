#!/usr/bin/python3

class Solution:
    def myAtoi(self, str: str) -> int:
        sLen = len(str)
        if sLen == 0:
            return 0
        i = 0
        while i < sLen and str[i] == ' ':
            i += 1
        sign = 1
        if i < sLen:
            if str[i] == '-':
                i += 1
                sign = -1
            elif str[i] == '+':
                i += 1
        result = 0
        while i < sLen and '0' <= str[i] and str[i] <= '9':
            result = result * 10 + sign * (ord(str[i]) - ord('0'))
            if result < Solution.INT_MIN:
                return Solution.INT_MIN
            elif result > Solution.INT_MAX:
                return Solution.INT_MAX
            i += 1
        return result
    INT_MIN = -2**31
    INT_MAX = 2**31 - 1
