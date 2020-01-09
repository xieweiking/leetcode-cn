/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
    'use strict'
    let result = 0
    for (; x != 0; x = parseInt(x / 10))
        result = result * 10 + (x % 10)
    return (result < -2147483648 || 2147483647 < result ?
            0 : result);
};
