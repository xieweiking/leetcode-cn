/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
    'use strict'
    return new RegExp(`^${p}$`, 'g').test(s)
};
