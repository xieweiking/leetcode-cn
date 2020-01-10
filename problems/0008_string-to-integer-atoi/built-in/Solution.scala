object Solution {
    def myAtoi(str: String): Int = {
        str match {
            case NUM_FMT(intStr) =>
                val result = BigInt(intStr)
                if (result < Int.MinValue)
                    Int.MinValue
                else if (result > Int.MaxValue)
                    Int.MaxValue
                else
                    result.toInt
            case _ =>
                0
        }
    }
    val NUM_FMT = """\s*([\-\+]?\d+).*""".r
}
