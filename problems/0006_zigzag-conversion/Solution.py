#!/usr/bin/python3

class Solution:
    def convert(self, s: str, numRows: int) -> str:
        sLen = len(s)
        if sLen <= 2 or numRows == 1:
            return s
        colsPerPad = numRows - 1
        charsPerPad = colsPerPad - 1 + numRows
        lastRow = colsPerPad
        def g():
            for r in range(numRows):
                for i in range(r, sLen, charsPerPad):
                    yield s[i]
                    j = i + charsPerPad - 2 * r
                    if r != 0 and r != lastRow and j < sLen:
                        yield s[j]
        return ''.join(g())
