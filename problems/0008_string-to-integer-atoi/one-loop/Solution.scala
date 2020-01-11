object Solution {
    def myAtoi(str: String): Int = {
        if (str.size == 0)
            return 0
        var i = 0
        while (i < str.size && str(i) == ' ') i += 1
        var sign = 1L
        if (i < str.size)
            if (str(i) == '-') {
                i += 1
                sign = -1L
            } else if (str(i) == '+')
                i += 1
        var result = 0L
        while (i < str.size && '0' <= str(i) && str(i) <= '9') {
            result = result * 10 + sign * (str(i) - '0')
            if (result < Int.MinValue)
                return Int.MinValue
            else if (result > Int.MaxValue)
                return Int.MaxValue
            i += 1
        }
        result.toInt
    }
}
