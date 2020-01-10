class Solution {
public:
    int myAtoi(string str) {
        const size_t sLen = str.length();
        if (sLen == 0)
            return 0;
        size_t i = 0;
        for (; i < sLen && str[i] == ' '; ++i);
        long sign = 1;
        if (i < sLen) {
            if (str[i] == '-') {
                ++i;
                sign = -1;
            } else if (str[i] == '+')
                ++i;
        }
        long result = 0;
        for (; i < sLen && '0' <= str[i] && str[i] <= '9'; i++) {
            result = result * 10 + sign * (str[i] - '0');
            if (result < INT_MIN)
                return INT_MIN;
            else if (result > INT_MAX)
                return INT_MAX;
        }
        return result;
    }
};
