func twoSum(nums []int, target int) []int {
    m := make(map[int]int, len(nums))
    for i, num := range nums {
        if j, ok := m[target - num]; ok {
            return []int{ j, i }
        }
        m[num] = i
    }
    panic(fmt.Sprintf("No match value for %v, %d!", nums, target))
}
