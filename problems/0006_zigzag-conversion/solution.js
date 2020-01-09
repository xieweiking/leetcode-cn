/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
    'use strict'
    if (s.length <= 2 || numRows === 1)
        return s
    const colsPerPad = numRows - 1,
          charsPerPad = colsPerPad - 1 + numRows,
          lastRow = colsPerPad
    let result = ''
    for (let r = 0; r < numRows; ++r)
        for (let i = r; i < s.length; i += charsPerPad) {
            result += s[i]
            if (r != 0 && r != lastRow) {
                const j = i + charsPerPad - 2 * r
                if (j < s.length)
                    result += s[j]
            }
        }
    return result
};
