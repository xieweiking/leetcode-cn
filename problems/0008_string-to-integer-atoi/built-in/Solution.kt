class Solution {
    fun myAtoi(str: String): Int {
        val matches = NUM_FMT.find(str)
        if (matches != null)
            try {
                val (s) = matches!!.destructured
                val result = s.toBigInteger()
                if (result < INT_MIN)
                    return Int.MIN_VALUE
                else if (result > INT_MAX)
                    return Int.MAX_VALUE
                else
                    return result.toInt()
            } catch (ignored: NumberFormatException) {
            }
        return 0
    }
    val INT_MIN = Int.MIN_VALUE.toBigInteger()
    val INT_MAX = Int.MAX_VALUE.toBigInteger()
    val NUM_FMT = """^\s*([\-\+]?\d+).*$""".toRegex()
}
