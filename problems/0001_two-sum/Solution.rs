use std::collections::HashMap;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut m = HashMap::with_capacity(nums.len());
        for (i, num) in nums.iter().enumerate() {
            if let Some(&j) = m.get(&(target - num)) {
                return vec![j as i32, i as i32];
            }
            m.insert(num, i);
        }
        panic!(format!("No match value for {nums:?}, {target}!",
                nums = nums, target = target));
    }
}
