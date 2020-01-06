use std::cmp;

impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        let (A, B) = if nums1.len() <= nums2.len() {
                         (nums1, nums2)
                     } else {
                         (nums2, nums1)
                     };
        let (m, n) = (A.len(), B.len());
        let total = m + n;
        let (h, is_odd) = (total / 2, total % 2 == 1);
        let (mut iBegin, mut iEnd) = (0, m);
        while iBegin <= iEnd {
            let i = (iBegin + iEnd) / 2;
            let j = h - i;
            if i < iEnd && 0 < j && A[i] < B[j - 1] {
                iBegin = i + 1;
            } else if iBegin < i && j < n && B[j] < A[i - 1] {
                iEnd = i - 1;
            } else {
                let minGreater = if i == m {
                                     B[j]
                                 } else if j == n {
                                     A[i]
                                 } else {
                                     cmp::min(A[i], B[j])
                                 };
                if is_odd {
                    return minGreater as f64;
                }
                let maxLesser = if i == 0 {
                                    B[j - 1]
                                } else if j == 0 {
                                    A[i - 1]
                                } else {
                                    cmp::max(A[i - 1], B[j - 1])
                                };
                return (maxLesser + minGreater) as f64 / 2.0;
            }
        }
        panic!("Should NOT be HERE!");
    }
}
