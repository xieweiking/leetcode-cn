#!/usr/bin/python3

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        sLen, pLen = len(s), len(p)
        memo = [[False for j in range(pLen + 1)] for i in range(sLen + 1)]
        memo[sLen][pLen] = True
        for i in range(sLen, -1, -1):
            for j in range(pLen - 1, -1, -1):
                matchChar = (i < sLen and \
                        (p[j] == s[i] or p[j] == '.'))
                memo[i][j] = (memo[i][j + 2] or (matchChar and memo[i + 1][j])) \
                        if j < pLen - 1 and p[j + 1] == '*' else \
                        (matchChar and memo[i + 1][j + 1])
        return memo[0][0]
