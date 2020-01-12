/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
    'use strict'
    if (x < 0)
        return false
    else if (x < 10)
        return true
    let reversed = 0
    for (let k = x; k != 0; k = parseInt(k / 10))
        reversed = reversed * 10 + (k % 10)
    return x == reversed
};
