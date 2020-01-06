class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] A, B;
        if (nums1.length <= nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }
        final int m = A.length,
                  n = B.length,
                  total = m + n,
                  h = total / 2;
        final boolean isOdd = (total % 2 == 1);
        for (int iBegin = 0, iEnd = m; iBegin <= iEnd;) {
            final int i = (iBegin + iEnd) / 2,
                      j = h - i;
            if (i < iEnd && 0 < j && A[i] < B[j - 1])
                iBegin = i + 1;
            else if (iBegin < i && j < n && B[j] < A[i - 1])
                iEnd = i - 1;
            else {
                final int minGreater = (i == m ?
                        B[j] :
                        (j == n ?
                            A[i] :
                            Math.min(A[i], B[j])));
                if (isOdd)
                    return minGreater;
                final int maxLesser = (i == 0 ?
                        B[j - 1] :
                        (j == 0 ?
                            A[i - 1] :
                            Math.max(A[i - 1], B[j - 1])));
                return (maxLesser + minGreater) / 2.0;
            }
        }
        throw new RuntimeException("Should NOT be HERE!");
    }
}
