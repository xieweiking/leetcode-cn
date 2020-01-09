impl Solution {
    pub fn convert(s: String, num_rows: i32) -> String {
        let s_len = s.len();
        if s_len <= 2 || num_rows == 1 {
            return s
        }
        let num_rows = num_rows as usize;
        let (ptr, cols_per_pad) = (s.as_ptr(), num_rows - 1);
        let (chars_per_pad, last_row) = (cols_per_pad - 1 + num_rows, cols_per_pad);
        let mut buf = Vec::with_capacity(s_len);
        for r in 0 .. num_rows {
            for i in (r .. s_len).step_by(chars_per_pad) {
                buf.push(unsafe { *(ptr.add(i)) } as char);
                if r != 0 && r != last_row {
                    let j = i + chars_per_pad - 2 * r;
                    if j < s_len {
                        buf.push(unsafe { *(ptr.add(j)) } as char);
                    }
                }
            }
        }
        buf.into_iter().collect()
    }
}
