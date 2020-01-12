class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        long reversed = 0;
        for (auto k = x; k != 0; k /= 10)
            reversed = reversed * 10 + (k % 10);
        return x == reversed;
    }
};
