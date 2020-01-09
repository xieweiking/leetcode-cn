class Solution {
    public String convert(String s, int numRows) {
        final int sLen = s.length();
        if (sLen <= 2 || numRows == 1)
            return s;
        final int colsPerPad = numRows - 1,
                  charsPerPad = colsPerPad - 1 + numRows,
                  lastRow = colsPerPad;
        final StringBuffer buf = new StringBuffer(sLen);
        for (int r = 0; r < numRows; ++r)
            for (int i = r; i < sLen; i += charsPerPad) {
                buf.append(s.charAt(i));
                final int j = i + charsPerPad - 2 * r;
                if (r != 0 && r != lastRow && j < sLen)
                    buf.append(s.charAt(j));
            }
        return buf.toString();
    }
}
