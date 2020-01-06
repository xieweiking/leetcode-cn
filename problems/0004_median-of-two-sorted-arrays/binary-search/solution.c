#define MIN(X,Y) ((X) < (Y) ? (X) : (Y))
#define MAX(X,Y) ((X) > (Y) ? (X) : (Y))
#define ERROR(fmt, ...) fprintf(stderr, fmt, ##__VA_ARGS__)

double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    int *A = nums1, *B = nums2, m = nums1Size, n = nums2Size;
    if (nums1Size > nums2Size) {
        A = nums2;
        m = nums2Size;
        B = nums1;
        n = nums1Size;
    }
    const int total = m + n,
              h = total / 2;
    const bool isOdd = (total % 2 == 1);
    for (int iBegin = 0, iEnd = m; iBegin <= iEnd;) {
        const int i = (iBegin + iEnd) / 2,
                  j = h - i;
        if (i < iEnd && 0 < j && A[i] < B[j - 1])
            iBegin = i + 1;
        else if (iBegin < i && j < n && B[j] < A[i - 1])
            iEnd = i - 1;
        else {
            const int minGreater = (i == m ?
                    B[j] :
                    (j == n ?
                        A[i] :
                        MIN(A[i], B[j])));
            if (isOdd)
                return minGreater;
            const int maxLesser = (i == 0 ?
                    B[j - 1] :
                    (j == 0 ?
                        A[i - 1] :
                        MAX(A[i - 1], B[j - 1])));
            return (maxLesser + minGreater) / 2.0;
        }
    }
    ERROR("Should NOT be HERE!");
    return NAN;
}
