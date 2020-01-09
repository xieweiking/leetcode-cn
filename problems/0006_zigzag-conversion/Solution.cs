using System.Text;

public class Solution {
    public string Convert(string s, int numRows) {
        if (s.Length <= 2 || numRows == 1)
            return s;
        int colsPerPad = numRows - 1,
            charsPerPad = colsPerPad - 1 + numRows,
            lastRow = colsPerPad;
        var buf = new StringBuilder(s.Length);
        for (var r = 0; r < numRows; ++r)
            for (var i = r; i < s.Length; i += charsPerPad) {
                buf.Append(s[i]);
                var j = i + charsPerPad - 2 * r;
                if (r != 0 && r != lastRow && j < s.Length)
                    buf.Append(s[j]);
            }
        return buf.ToString();
    }
}
