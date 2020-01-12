class Solution {
    fun isMatch(s: String, p: String): Boolean {
        return "^$p$".toRegex().find(s) != null
    }
}
