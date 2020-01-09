object Solution {
    def reverse(x: Int): Int = {
        var n = x
        var result = 0L
        while (n != 0) {
            result = result * 10 + (n % 10)
            n /= 10
        }
        if (result < Int.MinValue || Int.MaxValue < result)
            0
        else
            result.toInt
    }
}
