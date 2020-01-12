extern crate regex;

use regex::Regex;

impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        Regex::new(&format!("^{}$", p)).unwrap().is_match(&s)
    }
}
