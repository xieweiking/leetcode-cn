use std::i32;

impl Solution {
    pub fn my_atoi(str: String) -> i32 {
        let l = str.len();
        if l == 0 {
            return 0;
        }
        let (mut i, ptr) = (0, str.as_ptr());
        while i < l && unsafe { *(ptr.add(i)) } as char == ' ' {
            i += 1;
        }
        let (mut c, mut j) = (unsafe { *(ptr.add(i)) } as char, i);
        while j < l && ((j == i && (c == '+' || c == '-')) || ('0' <= c && c <= '9')) {
            j += 1;
            c = unsafe { *(ptr.add(j)) } as char;
        }
        if i == j {
            return 0;
        }
        let s = &str[i..j];
        match s.parse::<i32>() {
            Ok(result) => result,
            Err(e) => {
                let msg = e.to_string();
                if msg == "number too large to fit in target type" {
                    i32::MAX
                } else if msg == "number too small to fit in target type" {
                    i32::MIN
                } else {
                    0
                }
            }
        }
    }
}
