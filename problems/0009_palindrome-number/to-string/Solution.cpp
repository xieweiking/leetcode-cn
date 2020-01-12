using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x < 10)
            return true;
        const string s = to_string(x);
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j)
            if (s[i] != s[j])
                return false;
        return true;
    }
};
