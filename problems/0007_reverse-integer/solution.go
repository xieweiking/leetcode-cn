const MaxInt32 = int64(^uint32(0) >> 1)
const MinInt32 = -MaxInt32 - 1

func reverse(x int) int {
    result := int64(0)
    for x != 0 {
        result = result * 10 + int64(x % 10)
        x /= 10
    }
    if result < MinInt32 || MaxInt32 < result {
        return 0
    } else {
        return int(result)
    }
}
