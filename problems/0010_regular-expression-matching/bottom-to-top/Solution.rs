impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        let (s_len, p_len, s_ptr, p_ptr) = (s.len(), p.len(), s.as_ptr(), p.as_ptr());
        let mut memo = vec![vec![false; p_len + 1]; s_len + 1];
        memo[s_len][p_len] = true;
        for i in (0..(s_len + 1)).rev() {
            for j in (0..p_len).rev() {
                let match_char = (i < s_len &&
                        (unsafe { *(p_ptr.add(j)) == *(s_ptr.add(i)) } ||
                            unsafe { *(p_ptr.add(j)) } as char == '.'));
                memo[i][j] = if j + 1 < p_len && unsafe { *(p_ptr.add(j + 1)) } as char == '*' {
                            (memo[i][j + 2] || (match_char && memo[i + 1][j]))
                        } else {
                            (match_char && memo[i + 1][j + 1])
                        };
            }
        }
        memo[0][0]
    }
}
