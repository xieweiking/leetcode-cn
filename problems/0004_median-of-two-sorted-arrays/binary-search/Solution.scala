object Solution {
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val (a, b) = if (nums1.size <= nums2.size) (nums1, nums2)
                     else (nums2, nums1)
        val (m, n) = (a.size, b.size)
        val total = m + n
        val (h, isOdd) = (total / 2, total % 2 == 1)
        var (iBegin, iEnd) = (0, m)
        while (iBegin <= iEnd) {
            val i = (iBegin + iEnd) / 2
            val j = h - i
            if (i < iEnd && 0 < j && a(i) < b(j - 1))
                iBegin = i + 1
            else if (iBegin < i && j < n && b(j) < a(i - 1))
                iEnd = i - 1
            else {
                val minGreater = if (i == m) b(j)
                                 else if (j == n) a(i)
                                 else a(i).min(b(j))
                if (isOdd)
                    return minGreater
                val maxLesser = if (i == 0) b(j - 1)
                                else if (j == 0) a(i - 1)
                                else a(i - 1).max(b(j - 1))
                return (maxLesser + minGreater) / 2.0
            }
        }
        throw new RuntimeException("Should NOT be HERE!")
    }
}
