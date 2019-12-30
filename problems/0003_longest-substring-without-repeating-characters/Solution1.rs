use std::cmp;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut max = 0;
        let (mut start, mut end) = (0 as usize, 0 as usize);
        for c in s.chars() {
            let x = Self::find(s.as_ptr(), c, start, end);
            end += 1;
            if let Some(idx) = x {
                start = idx + 1;
            } else {
                max = cmp::max(max, (end - start) as i32);
            }
        }
        max
    }
    #[inline]
    fn find(ptr: *const u8, c: char, start: usize, end: usize) -> Option<usize> {
        for i in start..end {
            if unsafe { *(ptr.add(i)) } as char == c {
                return Some(i);
            }
        }
        None
    }
}
