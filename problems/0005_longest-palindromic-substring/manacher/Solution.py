#!/usr/bin/python3

class Solution:
    def longestPalindrome(self, s: str) -> str:
        sLen = len(s)
        if sLen <= 1:
            return s
        size = 2 * sLen + 1
        t = []
        for i in range(sLen):
            t.append(0)
            t.append(s[i])
        t.append(0)
        pLens = []
        c, r, maxPLen, idx = 0, 0, 0, 0
        for i in range(0, size):
            j = 2 * c - i
            pLen = min(r - i, pLens[j]) if r > i else 0
            posLeft, posRight = i - (pLen + 1), i + (pLen + 1)
            while 0 <= posLeft and posRight < size and \
                    t[posLeft] == t[posRight]:
                pLen += 1
                posLeft -= 1
                posRight += 1
            pLens.append(pLen)
            newR = i + pLen
            if newR > r:
                c, r = i, newR
            if pLen > maxPLen:
                maxPLen, idx = pLen, i
        start = (idx - maxPLen) // 2
        return s[start:start + maxPLen]
