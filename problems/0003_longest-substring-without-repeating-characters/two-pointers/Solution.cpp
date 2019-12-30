using namespace std;

inline size_t indexOf(const string& s, const char c, const size_t start, const size_t end) {
    for (size_t i = start; i < end; ++i)
        if (s[i] == c)
            return i;
    return string::npos;
}

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        size_t m = 0, start = 0, end = 0;
        for (const char& c : s) {
            const size_t idx = indexOf(s, c, start, end);
            ++end;
            if (idx == string::npos)
                m = max(m, end - start);
            else
                start = idx + 1;
        }
        return m;
    }
};
