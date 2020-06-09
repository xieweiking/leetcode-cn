function findMedianSortedArrays(nums1: number[], nums2: number[]): number {
    const [A, B] = (nums1.length <= nums2.length ? [nums1, nums2] : [nums2, nums1]),
        m = A.length,
        n = B.length,
        total = m + n,
        h = total >> 1,
        isOdd = (total % 2 === 1)
    for (let iBegin = 0, iEnd = m; iBegin <= iEnd;) {
        const i = (iBegin + iEnd) >> 1,
            j = h - i
        if (i < iEnd && 0 < j && A[i] < B[j - 1]) // A[i] is too small
            iBegin = i + 1
        else if (iBegin < i && j < n && B[j] < A[i - 1]) // A[i-1] is too large
            iEnd = i - 1
        else {
            const minGreater = (i === m ? // A is empty OR all A[i] < B[j-1]
                    B[j] :
                    (j === n ? // m == n AND all B[j] < A[i-1]
                        A[i] :
                        Math.min(A[i], B[j])))
            if (isOdd)
                return minGreater
            const maxLesser = (i === 0 ? // A is empty OR all B[j] < A[i-1]
                    B[j - 1] :
                    (j === 0 ? // h == i AND all A[i] < B[j-1]
                        A[i - 1] :
                        Math.max(A[i - 1], B[j - 1])))
            return (maxLesser + minGreater) / 2
        }
    }
    throw `Should NOT be HERE!`
};
