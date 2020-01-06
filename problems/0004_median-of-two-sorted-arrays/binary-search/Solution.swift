class Solution {
    func findMedianSortedArrays(_ nums1: [Int], _ nums2: [Int]) -> Double {
        let (A, B) = (nums1.count <= nums2.count ?
                (nums1, nums2) : (nums2, nums1))
        let (m, n) = (A.count, B.count)
        let total = m + n
        let (h, isOdd) = (total / 2, total % 2 == 1)
        var (iBegin, iEnd) = (0, m)
        while iBegin <= iEnd {
            let i = (iBegin + iEnd) / 2
            let j = h - i
            if i < iEnd && 0 < j && A[i] < B[j - 1] {
                iBegin = i + 1
            } else if iBegin < i && j < n && B[j] < A[i - 1] {
                iEnd = i - 1
            } else {
                let minGreater = (i == m ?
                        B[j] :
                        (j == n ?
                            A[i] :
                            min(A[i], B[j])))
                if isOdd {
                    return Double(minGreater)
                }
                let maxLesser = (i == 0 ?
                        B[j - 1] :
                        (j == 0 ?
                            A[i - 1] :
                            max(A[i - 1], B[j - 1])))
                return Double(maxLesser + minGreater) / 2.0
            }
        }
        fatalError("Should NOT be HERE!")
    }
}
