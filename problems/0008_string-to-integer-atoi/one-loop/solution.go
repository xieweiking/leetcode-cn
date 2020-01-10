func myAtoi(str string) int {
    sLen := len(str)
    if sLen == 0 {
        return 0
    }
    i := 0
    for i < sLen && str[i] == ' ' {
        i++
    }
    sign := 1
    if i < sLen {
        if str[i] == '-' {
            i++
            sign = -1
        } else if str[i] == '+' {
            i++
        }
    }
    result := 0
    for i < sLen && '0' <= str[i] && str[i] <= '9' {
        result = result * 10 + sign * int(str[i] - '0')
        if result < MinInt32 {
            return MinInt32
        } else if result > MaxInt32 {
            return MaxInt32
        }
        i++
    }
    return result
}

const MaxInt32 = int(^uint32(0) >> 1)
const MinInt32 = -MaxInt32 - 1
