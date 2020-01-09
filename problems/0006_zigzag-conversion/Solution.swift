class Solution {
    func convert(_ s: String, _ numRows: Int) -> String {
        let sLen = s.count
        if sLen <= 2 || numRows == 1 {
            return s
        }
        let (chars, colsPerPad) = (Array(s), numRows - 1)
        let (charsPerPad, lastRow) = (colsPerPad - 1 + numRows, colsPerPad)
        var (buf, k) = ([Character](repeating: " ", count: sLen), 0)
        for r in 0 ..< numRows {
            for i in stride(from: r, to: sLen, by: charsPerPad) {
                buf[k] = chars[i]
                k += 1
                if r != 0 && r != lastRow {
                    let j = i + charsPerPad - 2 * r
                    if j < sLen {
                        buf[k] = chars[j]
                        k += 1
                    }
                }
            }
        }
        return String(buf)
    }
}
