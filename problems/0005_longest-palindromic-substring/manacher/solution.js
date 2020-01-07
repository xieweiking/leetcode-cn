/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
    'use strict'
    if (s === '')
        return ''
    const t = '^#' + s.split('').join('#') + '#$',
          pLens = new Array(t.length),
          posEnd = t.length - 1
    for (let i = 0, posMax = 0, posRight = 1;
            posRight < posEnd;
            ++posRight) {
        const posLeft = 2 * i - posRight
        let pLen = (posMax > posRight ?
                Math.min(posMax - posRight, pLens[posLeft]) : 0)
        while (t[posRight + 1 + pLen] === t[posRight - 1 - pLen])
            ++pLen
        const newPosMax = posRight + (pLens[posRight] = pLen)
        if (newPosMax > posMax) {
            i = posRight
            posMax = newPosMax
        }
    }
    let maxPLen = 0, i = 0
    for (let pos = 1, pLen = pLens[pos];
            pos < posEnd;
            pLen = pLens[++pos])
        if (pLen > maxPLen)
            [maxPLen, i] = [pLen, pos]
    const start = (i - maxPLen) >> 1
    return s.substring(start, start + maxPLen)
};
