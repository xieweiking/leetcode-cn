#!/usr/bin/python3

class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        sLen, pLen = len(s), len(p)
        if pLen == 0: return (sLen == 0)
        p0 = p[0]
        matchP0 = (sLen > 0 and \
                (p0 == s[0] or p0 == '.'))
        if pLen >= 2 and p[1] == '*':
            return (self.isMatch(s, p[2:]) or \
                    (matchP0 and self.isMatch(s[1:], p)))
        else:
            return (matchP0 and self.isMatch(s[1:], p[1:]))
