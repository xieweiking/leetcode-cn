#!/usr/bin/python3

class Solution:
    def longestPalindrome(self, s: str) -> str:
        sLen = len(s)
        maxLeft, maxRight = 0, 0
        for i in range(0, sLen * 2 - 1):
            posLeft = i // 2
            posRight = posLeft + 1 if i % 2 == 1 else posLeft
            while 0 <= posLeft and posRight < sLen and \
                    s[posLeft] == s[posRight]:
                posLeft -= 1
                posRight += 1
            posLeft += 1
            if posRight - posLeft > maxRight - maxLeft:
                maxLeft, maxRight = posLeft, posRight
        return s[maxLeft:maxRight]
