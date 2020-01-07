/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    'use strict'
    const iEnd = s.length * 2 - 1
    let [maxLeft, maxRight] = [0, 0]
    for (let i = 0; i < iEnd; ++i) {
        let posLeft = i >> 1,
            posRight = (i % 2 === 1 ? posLeft + 1 : posLeft)
        while (0 <= posLeft && posRight < s.length &&
                s[posLeft] === s[posRight]) {
            --posLeft
            ++posRight
        }
        if (posRight - (++posLeft) > maxRight - maxLeft)
            [maxLeft, maxRight] = [posLeft, posRight]
    }
    return s.substring(maxLeft, maxRight)
};
