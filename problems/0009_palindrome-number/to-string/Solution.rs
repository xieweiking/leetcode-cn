impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 {
            return false;
        } else if x < 10 {
            return true;
        }
        let chars: Vec<char> = x.to_string().chars().collect();
        let (mut i, mut j) = (0, chars.len() - 1);
        while i < j {
            if chars[i] != chars[j] {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
}
