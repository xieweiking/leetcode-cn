class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var A = nums1
        var B = nums2
        if (A.size > B.size) {
            A = nums2
            B = nums1
        }
        val m = A.size
        val n = B.size
        val total = m + n
        val h = total / 2
        val isOdd = (total % 2 == 1)
        var iBegin = 0
        var iEnd = m
        while (iBegin <= iEnd) {
            val i = (iBegin + iEnd) / 2
            val j = h - i
            if (i < iEnd && 0 < j && A[i] < B[j - 1])
                iBegin = i + 1
            else if (iBegin < i && j < n && B[j] < A[i - 1])
                iEnd = i - 1
            else {
                val minGreater = if (i == m) B[j]
                                 else if (j == n) A[i]
                                 else Math.min(A[i], B[j])
                if (isOdd)
                    return minGreater.toDouble()
                val maxLesser = if (i == 0) B[j - 1]
                                else if (j == 0) A[i - 1]
                                else Math.max(A[i - 1], B[j - 1])
                return (maxLesser + minGreater) / 2.0
            }
        }
        throw Exception("Should NOT be HERE!")
    }
}
