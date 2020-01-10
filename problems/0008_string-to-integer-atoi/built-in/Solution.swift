class Solution {
    func myAtoi(_ str: String) -> Int {
        if let match = NUM_FMT.firstMatch(
                in: str, range: NSRange(location: 0, length: str.count)) {
            if let r = Range(match.range(at: 1), in: str) {
                if let result = Decimal(string: String(str[r])) {
                    if result < INT32_MIN_DEC {
                        return INT32_MIN_INT
                    } else if result > INT32_MAX_DEC {
                        return INT32_MAX_INT
                    } else {
                        return Int(NSDecimalNumber(decimal: result))
                    }
                }
            }
        }
        return 0
    }
    let (INT32_MIN_DEC, INT32_MAX_DEC,
         INT32_MIN_INT, INT32_MAX_INT,
         NUM_FMT) =
            (Decimal(Int32.min), Decimal(Int32.max),
             Int(Int32.min), Int(Int32.max),
             try! NSRegularExpression(pattern: "^\\s*([\\-\\+]?\\d+).*$"))
}
