import scala.collection.mutable.Map

object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val m = Map[Int, Int]()
        nums.zipWithIndex.foreach { case (num, i) =>
            m.get(target - num).foreach { j =>
                return Array(j, i)
            }
            m += (num -> i)
        }
        throw new Exception(s"No match value for $nums, $target!")
    }
}
