public class Solution {
    public double FindMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        if (nums1.Length > nums2.Length) {
            A = nums2;
            B = nums1;
        }
        int m = A.Length,
            n = B.Length,
            total = m + n,
            h = total / 2;
        bool isOdd = (total % 2 == 1);
        for (int iBegin = 0, iEnd = m; iBegin <= iEnd;) {
            int i = (iBegin + iEnd) / 2,
                j = h - i;
            if (i < iEnd && 0 < j && A[i] < B[j - 1])
                iBegin = i + 1;
            else if (iBegin < i && j < n && B[j] < A[i - 1])
                iEnd = i - 1;
            else {
                var minGreater = (i == m ?
                        B[j] :
                        (j == n ?
                            A[i] :
                            Math.Min(A[i], B[j])));
                if (isOdd)
                    return minGreater;
                var maxLesser = (i == 0 ?
                        B[j - 1] :
                        (j == 0 ?
                            A[i - 1] :
                            Math.Max(A[i - 1], B[j - 1])));
                return (maxLesser + minGreater) / 2.0;
            }
        }
        throw new System.Exception("Should NOT be HERE!");
    }
}
