object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        var (max, start, end) = (0, 0, 0)
        for (c <- s) {
            val x = find(s, c, start, end)
            end += 1
            x match {
                case Some(idx) =>
                    start = idx + 1
                case None =>
                    max = (end - start).max(max)
            }
        }
        max
    }
    @inline
    def find(s: String, c: Char, start: Int, end: Int): Option[Int] = {
        for (i <- start until end)
            if (s(i) == c)
                return Some(i)
        None
    }
}
