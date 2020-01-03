/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    'use strict'
    const [A, B] = (nums1.length <= nums2.length ?
            [nums1, nums2] :
            [nums2, nums1])
    const total = A.length + B.length,
          isOdd = (total % 2 === 1),
          half = (total + 1) >> 1
    for (let iMin = 0, iMax = A.length; iMin <= iMax;) {
        const i = (iMin + iMax) >> 1,
              j = half - i,
              a = A[i],
              aPrev = A[i - 1],
              b = B[j],
              bPrev = B[j - 1]
        if (i < iMax && a < bPrev)
            iMin = i + 1
        else if (i > iMin && aPrev > b)
            iMax = i - 1
        else {
            const left = (i === 0 ?
                    bPrev :
                    (j === 0 ?
                        aPrev :
                        Math.max(aPrev, bPrev)))
            if (isOdd)
                return left
            const right = (i === A.length ?
                    b :
                    (j === B.length ?
                        a :
                        Math.min(a, b)))
            return (left + right) / 2
        }
    }
    throw `Should NOT be HERE!`
};
