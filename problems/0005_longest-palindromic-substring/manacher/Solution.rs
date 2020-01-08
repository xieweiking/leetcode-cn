use std::cmp;

impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        let s_len = s.len();
        if s_len <= 1 {
            return s;
        }
        let ptr = s.as_ptr();
        let size = 2 * s_len + 1;
        let mut t = Vec::with_capacity(size);
        for i in 0..s_len {
            t.push('\0');
            t.push(unsafe { *(ptr.add(i)) } as char);
        }
        t.push('\0');
        let mut p_lens = Vec::with_capacity(size);
        let (mut c, mut r, mut max_p_len, mut idx) = (0, 0, 0, 0);
        for i in 0..size {
            let j = 2 * c - i;
            let mut p_len = if r > i {
                                cmp::min(r - i, p_lens[j])
                            } else {
                                0
                            };
            let (mut pos_left, mut pos_right) =
                    (i as i32 - (p_len + 1) as i32, i + (p_len + 1));
            while 0 <= pos_left && pos_right < size &&
                    t[pos_left as usize] == t[pos_right] {
                p_len += 1;
                pos_left -= 1;
                pos_right += 1;
            }
            p_lens.push(p_len);
            let new_r = i + p_len;
            if new_r > r {
                c = i;
                r = new_r;
            }
            if p_len > max_p_len {
                max_p_len = p_len;
                idx = i;
            }
        }
        let start = (idx - max_p_len) / 2;
        s[start..(start + max_p_len)].to_string()
    }
}
