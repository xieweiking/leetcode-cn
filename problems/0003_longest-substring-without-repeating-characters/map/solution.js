/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    'use strict'
    const map = new Map()
    let max = 0
    for (let start = 0, end = 0; end < s.length;) {
        const c = s[end],
              idx = map.get(c)
        map.set(c, end++)
        if (idx === undefined || idx < start)
            max = Math.max(max, end - start)
        else
            start = idx + 1
    }
    return max
};
