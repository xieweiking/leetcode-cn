func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
    A, m, B, n := nums1, len(nums1), nums2, len(nums2)
    if m > n {
        A, m, B, n = B, n, A, m
    }
    total := m + n
    h, isOdd := total / 2, total % 2 == 1
    iBegin, iEnd := 0, m
    for iBegin <= iEnd {
        i := (iBegin + iEnd) / 2
        j := h - i
        if i < iEnd && 0 < j && A[i] < B[j - 1] {
            iBegin = i + 1
        } else if iBegin < i && j < n && B[j] < A[i - 1] {
            iEnd = i - 1
        } else {
            minGreater := 0
            if i == m {
                minGreater = B[j]
            } else if j == n {
                minGreater = A[i]
            } else {
                if A[i] < B[j] {
                    minGreater = A[i]
                } else {
                    minGreater = B[j]
                }
            }
            if isOdd {
                return float64(minGreater)
            }
            maxLesser := 0
            if i == 0 {
                maxLesser = B[j - 1]
            } else if j == 0 {
                maxLesser = A[i - 1]
            } else {
                if A[i - 1] > B[j - 1] {
                    maxLesser = A[i - 1]
                } else {
                    maxLesser = B[j - 1]
                }
            }
            return float64(maxLesser + minGreater) / 2.0
        }
    }
    panic("Should NOT be HERE!")
}
