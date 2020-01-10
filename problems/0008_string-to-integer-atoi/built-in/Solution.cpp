using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        try {
            const long long result = stoll(str);
            if (result < INT_MIN)
                return INT_MIN;
            else if (result > INT_MAX)
                return INT_MAX;
            else
                return (int) result;
        } catch (invalid_argument& ignored) {
        } catch (out_of_range& ignored) {
            const size_t sLen = str.length();
            for (size_t i = 0; i < sLen; ++i) {
                const char c = str[i];
                if (c == '-')
                    return INT_MIN;
                else if (c == '+' || '0' <= c && c <= '9')
                    return INT_MAX;
            }
        }
        return 0;
    }
};
