using namespace std;

class Solution {
public:
    int myAtoi(string str) {
        try {
            return stoi(str);
        } catch (invalid_argument& ignored) {
        } catch (out_of_range& ignored) {
            for (const char& c : str)
                if (c == '-')
                    return INT_MIN;
                else if (c == '+' || '0' <= c && c <= '9')
                    return INT_MAX;
        }
        return 0;
    }
};
