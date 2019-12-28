class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val m = HashMap<Int, Int>(nums.size + 1, 0.99f)
        nums.forEachIndexed { i, num ->
            val j = m[target - num]
            if (j != null)
                return intArrayOf(j, i)
            m.put(num, i)
        }
        throw Exception("No match value for $nums, $target!")
    }
}
