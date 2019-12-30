/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function (s) {
    'use strict'
    function find(c, start, end) {
        for (let i = start; i < end; ++i)
            if (s[i] === c)
                return i
        return -1
    }
    let max = 0
    for (let i = 0, start = 0, end = 0; i < s.length; ++i) {
        const idx = find(s[i], start, end)
        ++end
        if (idx === -1)
            max = Math.max(max, end - start)
        else
            start = idx + 1
    }
    return max
};
