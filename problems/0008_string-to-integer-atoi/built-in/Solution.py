#!/usr/bin/python3

import re

class Solution:
    def myAtoi(self, str: str) -> int:
        matcher = Solution.NUM_FMT.match(str)
        if matcher is not None:
            try:
                result = int(matcher.group(1))
                if result < Solution.INT_MIN:
                    return Solution.INT_MIN
                elif result > Solution.INT_MAX:
                    return Solution.INT_MAX
                else:
                    return result
            except ValueError:
                pass
        return 0
    NUM_FMT = re.compile(r'\s*([\-\+]?\d+).*')
    INT_MIN = -2**31
    INT_MAX = 2**31 - 1
