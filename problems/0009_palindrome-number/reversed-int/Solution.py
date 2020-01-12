#!/usr/bin/python3

class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        elif x < 10:
            return True
        reversed, k = 0, x
        while k != 0:
            reversed = reversed * 10 + (k % 10)
            k //= 10
        return x == reversed
