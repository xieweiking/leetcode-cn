import (
    "strconv"
    "regexp"
)

func myAtoi(str string) int {
    numFmt := regexp.MustCompile(`^\s*([\-\+]?\d+).*$`)
    matches := numFmt.FindStringSubmatch(str)
    if matches != nil {
        result, _ := strconv.Atoi(matches[1])
        if result < MinInt32 {
            return MinInt32
        } else if result > MaxInt32 {
            return MaxInt32
        } else {
            return result
        }
    }
    return 0
}

const MaxInt32 = int(^uint32(0) >> 1)
const MinInt32 = -MaxInt32 - 1
