#!/usr/bin/python3

class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        x *= sign
        result = 0
        while x != 0:
            result = result * 10 + (x % 10)
            x //= 10
        result *= sign
        return 0 if result < -2**31 or 2**31 - 1 < result else result
