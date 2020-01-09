/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    'use strict'
    const sign = Math.sign(x)
    x *= sign
    let result = 0
    while (x != 0) {
        const r = x % 10
        result = result * 10 + r
        x = (x - r) / 10
    }
    result *= sign
    if (result < -2147483648 || 2147483647 < result)
        return 0
    else
        return result
};
