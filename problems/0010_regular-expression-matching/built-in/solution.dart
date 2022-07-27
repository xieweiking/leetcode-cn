class Solution {
    bool isMatch(String s, String p) {
        final cp = RegExp('^$p\$');
        return cp.hasMatch(s);
    }
}