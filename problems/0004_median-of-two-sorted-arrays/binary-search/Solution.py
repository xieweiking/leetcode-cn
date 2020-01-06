#!/usr/bin/python3

class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        A, m, B, n = nums1, len(nums1), nums2, len(nums2)
        if m > n:
            A, m, B, n = B, n, A, m
        total = m + n
        h = total // 2
        isOdd = (total % 2 == 1)
        iBegin, iEnd = 0, m
        while iBegin <= iEnd:
            i = (iBegin + iEnd) // 2
            j = h - i
            if i < iEnd and 0 < j and A[i] < B[j - 1]:
                iBegin = i + 1
            elif iBegin < i and j < n and B[j] < A[i - 1]:
                iEnd = i - 1
            else:
                minGreater = B[j] if i == m else (
                        A[i] if j == n else min(A[i], B[j]))
                if isOdd:
                    return minGreater
                maxLesser = B[j - 1] if i == 0 else (
                        A[i - 1] if j == 0 else max(A[i - 1], B[j - 1]))
                return (maxLesser + minGreater) / 2
        raise Exception("Should NOT be HERE!")
