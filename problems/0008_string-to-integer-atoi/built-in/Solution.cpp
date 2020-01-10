using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        try {
            const long result = stol(str);
            if (result < INT_MIN)
                return INT_MIN;
            else if (result > INT_MAX)
                return INT_MAX;
            else
                return (int) result;
        } catch (invalid_argument& ignored) {
        } catch (out_of_range& ignored) {
            for (char& c : str)
                if (c == '-')
                    return INT_MIN;
                else if (c == '+' || '0' <= c && c <= '9')
                    return INT_MAX;
        }
        return 0;
    }
};
