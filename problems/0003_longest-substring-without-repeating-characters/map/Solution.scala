import scala.collection.mutable.Map

object Solution {
    def lengthOfLongestSubstring(s: String): Int = {
        val map = Map[Char, Int]()
        var (max, start, end) = (0, 0, 0)
        for (c <- s) {
            val x = map.get(c)
            map += (c -> end)
            end += 1
            x match {
                case Some(idx) if idx >= start =>
                    start = idx + 1
                case _ =>
                    max = (end - start).max(max)
            }
        }
        max
    }
}
