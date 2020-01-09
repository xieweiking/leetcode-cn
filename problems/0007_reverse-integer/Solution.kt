class Solution {
    fun reverse(x: Int): Int {
        var n = x
        var result = 0L
        while (n != 0) {
            result = result * 10 + (n % 10)
            n /= 10
        }
        return if (result < Int.MIN_VALUE || Int.MAX_VALUE < result)
                    0
                else
                    result.toInt()
    }
}
