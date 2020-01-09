class Solution {
    fun convert(s: String, numRows: Int): String {
        if (s.length <= 2 || numRows == 1)
            return s
        val colsPerPad = numRows - 1
        val charsPerPad = colsPerPad - 1 + numRows
        val lastRow = colsPerPad
        val buf = StringBuilder(s.length)
        for (r in 0 .. (numRows - 1))
            for (i in r .. (s.length - 1) step charsPerPad) {
                buf.append(s[i])
                if (r != 0 && r != lastRow) {
                    val j = i + charsPerPad - 2 * r;
                    if (j < s.length)
                        buf.append(s[j])
                }
            }
        return buf.toString()
    }
}
