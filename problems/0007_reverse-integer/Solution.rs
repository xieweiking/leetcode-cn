use std::i32;

impl Solution {
    pub fn reverse(x: i32) -> i32 {
        let (mut result, mut n) = (0i64, x);
        while n != 0 {
            result = result * 10 + (n % 10) as i64;
            n /= 10
        }
        if result < (i32::MIN as i64) || (i32::MAX as i64) < result {
            0
        } else {
            result as i32
        }
    }
}
