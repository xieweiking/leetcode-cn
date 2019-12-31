impl Solution {
    pub fn find_median_sorted_arrays(nums1: Vec<i32>, nums2: Vec<i32>) -> f64 {
        let mut nums = [&nums1[..], &nums2[..]].concat();
        nums.sort();
        let size = nums.len();
        let i = size / 2;
        return if size % 2 == 0 {
            (nums[i - 1] + nums[i]) as f64 / 2.0
        } else {
            nums[i] as f64
        };
    }
}
