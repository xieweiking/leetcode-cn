class Solution {
public:
    int myAtoi(string str) {
        const size_t sLen = str.length();
        if (sLen == 0)
            return 0;
        size_t i = 0;
        for (; str[i] == ' '; ++i);
        long sign = 1;
        if (str[i] == '-') {
            ++i;
            sign = -1;
        } else if (str[i] == '+')
            ++i;
        long result = 0;
        for (char c = str[i]; i < sLen && '0' <= c && c <= '9'; c = str[++i]) {
            result = result * 10 + sign * (c - '0');
            if (result < INT_MIN)
                return INT_MIN;
            else if (result > INT_MAX)
                return INT_MAX;
        }
        return result;
    }
};
