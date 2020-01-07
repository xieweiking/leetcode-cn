impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        let s_len = s.len();
        let (mut max_left, mut max_right) = (0, 0);
        if s_len > 0 {
            let ptr = s.as_ptr();
            for i in 0..(s_len * 2 - 1) {
                let mut pos_left = i / 2;
                let mut pos_right = if i % 2 == 1 {
                                        pos_left + 1
                                    } else {
                                        pos_left
                                    };
                while 0 <= pos_left && pos_right < s_len && unsafe {
                        *(ptr.add(pos_left)) ==  *(ptr.add(pos_right)) } {
                    pos_left -= 1;
                    pos_right += 1;
                }
                pos_left += 1;
                if pos_right - pos_left > max_right - max_left {
                    max_left = pos_left;
                    max_right = pos_right;
                }
            }
        }
        s[max_left..max_right].to_string()
    }
}
