func convert(s string, numRows int) string {
    sLen := len(s)
    if sLen <= 2 || numRows == 1 {
        return s
    }
    runes, colsPerPad := []rune(s), numRows - 1
    charsPerPad, lastRow := colsPerPad - 1 + numRows, colsPerPad
    result := make([]rune, sLen)
    for r, k := 0, 0; r < numRows; r++ {
        for i := r; i < sLen; i += charsPerPad {
            result[k] = runes[i]
            k++
            if r != 0 && r != lastRow {
                j := i + charsPerPad - 2 * r
                if j < sLen {
                    result[k] = runes[j]
                    k++
                }
            }
        }
    }
    return string(result)
}
