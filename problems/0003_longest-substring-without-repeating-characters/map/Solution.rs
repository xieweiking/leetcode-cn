use std::cmp;
use std::collections::HashMap;

impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        let mut map = HashMap::with_capacity(256);
        let mut max = 0;
        let (mut start, mut end) = (0, 0);
        for c in s.chars() {
            let idx = *map.get(&c).unwrap_or(&-1);
            map.insert(c, end);
            end += 1;
            if idx == -1 || idx < start {
                max = cmp::max(max, end - start);
            } else {
                start = idx + 1;
            }
        }
        max
    }
}
