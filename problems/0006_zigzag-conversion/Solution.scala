object Solution {
    def convert(s: String, numRows: Int): String = {
        if (s.size <= 2 || numRows == 1)
            return s
        val colsPerPad = numRows - 1
        val charsPerPad = colsPerPad - 1 + numRows
        val lastRow = colsPerPad
        val buf = new StringBuilder(s.size)
        for (r <- 0 until numRows)
            for (i <- r until s.size by charsPerPad) {
                buf += s(i)
                val j = i + charsPerPad - 2 * r
                if (r != 0 && r != lastRow && j < s.size)
                    buf += s(j)
            }
        buf.toString
    }
}
