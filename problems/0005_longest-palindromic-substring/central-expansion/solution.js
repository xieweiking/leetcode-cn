/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    'use strict'
    const end = s.length * 2 - 1
    let result = [0, 0]
    for (let i = 0; i < end; ++i) {
        let x = i >> 1,
            y = (i % 2 === 1 ? x + 1 : x)
        for (; x >= 0 && y < s.length && s[x] === s[y]; --x, ++y);
        ++x
        if (y - x > result[1] - result[0])
            result = [x, y]
    }
    return s.substring(...result)
};
