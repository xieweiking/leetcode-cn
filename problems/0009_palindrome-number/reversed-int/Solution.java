class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        int reversed = 0;
        for (int k = x; k != 0; k /= 10)
            reversed = reversed * 10 + (k % 10);
        return x == reversed;
    }
}
