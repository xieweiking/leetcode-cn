/**
 * @param {string} str
 * @return {number}
 */
var myAtoi = function (str) {
    'use strict'
    if (str.length === 0)
        return 0
    let i = 0
    while (i < str.length && str[i] === ' ') ++i
    let sign = 1
    if (i < str.length)
        if (str[i] === '-') {
            ++i
            sign = -1
        } else if (str[i] === '+')
            ++i
    let result = 0
    for (; i < str.length && '0' <= str[i] && str[i] <= '9'; ++i) {
        result = result * 10 + sign * (str[i] - '0')
        if (result < INT_MIN)
            return INT_MIN
        else if (result > INT_MAX)
            return INT_MAX
    }
    return result
};

const INT_MAX = Math.pow(2, 31) - 1,
      INT_MIN = -Math.pow(2, 31)
