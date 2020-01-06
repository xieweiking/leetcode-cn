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
        let (mut i_begin, mut i_end) = (0, m);
        while i_begin <= i_end {
            let i = (i_begin + i_end) / 2;
            let j = h - i;
            if i < i_end && 0 < j && A[i] < B[j - 1] {
                i_begin = i + 1;
            } else if i_begin < i && j < n && B[j] < A[i - 1] {
                i_end = i - 1;
            } else {
                let min_greater = if i == m {
                                      B[j]
                                  } else if j == n {
                                      A[i]
                                  } else {
                                      cmp::min(A[i], B[j])
                                  };
                if is_odd {
                    return min_greater as f64;
                }
                let max_lesser = if i == 0 {
                                     B[j - 1]
                                 } else if j == 0 {
                                     A[i - 1]
                                 } else {
                                     cmp::max(A[i - 1], B[j - 1])
                                 };
                return (max_lesser + min_greater) as f64 / 2.0;
            }
        }
        panic!("Should NOT be HERE!");
    }
}
