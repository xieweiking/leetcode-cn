impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        let (s_len, p_len) = (s.len(), p.len());
        if p_len == 0 {
            return (s_len == 0);
        }
        let (s_ptr, p_ptr) = (s.as_ptr(), p.as_ptr());
        let p0 = unsafe { *(p_ptr.add(0)) } as char;
        let match_p0 = (s_len > 0 &&
                (p0 == unsafe { *(s_ptr.add(0)) } as char || p0 == '.'));
        if p_len >= 2 && unsafe { *(p_ptr.add(1)) } as char == '*' {
            return (Self::is_match(s.clone(), p[2..].to_string()) ||
                    (match_p0 && Self::is_match(s[1..].to_string(), p)));
        } else {
            return (match_p0 && Self::is_match(s[1..].to_string(), p[1..].to_string()));
        }
    }
}
