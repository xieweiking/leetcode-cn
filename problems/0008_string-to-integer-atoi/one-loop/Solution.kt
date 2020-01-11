class Solution {
    fun myAtoi(str: String): Int {
        if (str.length == 0)
            return 0
        var i = 0
        while (i < str.length && str[i] == ' ') i++
        var sign = 1L
        if (i < str.length)
            if (str[i] == '-') {
                i++
                sign = -1L
            } else if (str[i] == '+')
                i++
        var result = 0L
        while (i < str.length && '0' <= str[i] && str[i] <= '9') {
            result = result * 10 + sign * (str[i] - '0')
            if (result < Int.MIN_VALUE)
                return Int.MIN_VALUE
            else if (result > Int.MAX_VALUE)
                return Int.MAX_VALUE
            i++
        }
        return result.toInt()
    }
}
