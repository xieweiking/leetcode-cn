using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        const int sLen = s.length();
        if (sLen <= 2 || numRows == 1)
            return s;
        const int colsPerPad = numRows - 1,
                  charsPerPad = colsPerPad - 1 + numRows,
                  lastRow = colsPerPad;
        string result(sLen, ' ');
        for (int r = 0, k = 0; r < numRows; ++r)
            for (int i = r; i < sLen; i += charsPerPad) {
                result[k++] = s[i];
                const int j = i + charsPerPad - 2 * r;
                if (r != 0 && r != lastRow && j < sLen)
                    result[k++] = s[j];
            }
        return result;
    }
};
