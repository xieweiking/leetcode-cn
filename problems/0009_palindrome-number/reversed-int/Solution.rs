impl Solution {
    pub fn is_palindrome(x: i32) -> bool {
        if x < 0 {
            return false;
        } else if x < 10 {
            return true;
        }
        let (mut reversed, mut k) = (0, x);
        while k != 0 {
            reversed = reversed * 10 + (k % 10);
            k /= 10;
        }
        x == reversed
    }
}
