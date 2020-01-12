public class Solution {
    public bool IsPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        var reversed = 0;
        for (var k = x; k != 0; k /= 10)
            reversed = reversed * 10 + (k % 10);
        return x == reversed;
    }
}
