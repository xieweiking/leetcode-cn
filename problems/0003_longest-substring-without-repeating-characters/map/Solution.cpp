using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int map[256];
        fill_n(map, 256, -1);
        size_t m = 0, start = 0, end = 0;
        for (const char& c : s) {
            const size_t idx = map[c];
            map[c] = end++;
            if (idx == -1 || idx < start)
                m = max(m, end - start);
            else
                start = idx + 1;
        }
        return m;
    }
};
