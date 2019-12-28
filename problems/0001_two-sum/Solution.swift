class Solution {
    func twoSum(_ nums: [Int], _ target: Int) -> [Int] {
        var m = [Int : Int]()
        for (i, num) in nums.enumerated() {
            if let j = m[target - num] {
                return [j, i]
            }
            m[num] = i
        }
        fatalError("No match value for \(nums), \(target)!")
    }
}
