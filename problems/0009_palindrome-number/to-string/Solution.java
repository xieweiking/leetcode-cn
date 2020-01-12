class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        final String s = String.valueOf(x);
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
