public class Solution {
    public bool IsPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        var s = x.ToString();
        for (int i = 0, j = s.Length - 1; i < j; ++i, --j)
            if (s[i] != s[j])
                return false;
        return true;
    }
}
