/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
    'use strict'
    if (p.length == 0)
        return (s.length == 0)
    const p0 = p[0],
          matchP0 = (s.length > 0 &&
            (p0 == s[0] || p0 == '.'))
    if (p.length >= 2 && p[1] == '*')
        return (isMatch(s, p.substring(2)) ||
                (matchP0 && isMatch(s.substring(1), p)))
    else
        return (matchP0 && isMatch(s.substring(1), p.substring(1)))
};
