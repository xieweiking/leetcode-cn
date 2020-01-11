use std::i32;

impl Solution {
    pub fn my_atoi(str: String) -> i32 {
        let s_len = str.len();
        if s_len == 0 {
            return 0;
        }
        let (mut i, ptr) = (0, str.as_ptr());
        while i < s_len && unsafe { *(ptr.add(i)) } as char == ' ' {
            i += 1;
        }
        let mut sign = 1i64;
        if i < s_len {
            let c = unsafe { *(ptr.add(i)) } as char;
            if c == '-' {
                i += 1;
                sign = -1i64;
            } else if c == '+' {
                i += 1;
            }
        }
        let mut result = 0i64;
        while i < s_len {
            let c = unsafe { *(ptr.add(i)) } as char;
            if c < '0' || '9' < c {
                break;
            }
            result = result * 10 + sign * (c as i64 - '0' as i64);
            if result < i32::MIN as i64 {
                return i32::MIN;
            } else if result > i32::MAX as i64 {
                return i32::MAX;
            }
            i += 1;
        }
        result as i32
    }
}
