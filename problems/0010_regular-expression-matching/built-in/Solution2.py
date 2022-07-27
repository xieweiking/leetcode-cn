#!/usr/bin/python2

import re

class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        return re.compile('^' + p + '$').match(s) is not None
