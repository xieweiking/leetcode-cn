/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    'use strict'
    let result = 0
    for (; x != 0; x = parseInt(x / 10))
        result = result * 10 + (x % 10)
    return (result < -Math.pow(2, 31) || Math.pow(2, 31) - 1 < result ?
            0 : result);
};
