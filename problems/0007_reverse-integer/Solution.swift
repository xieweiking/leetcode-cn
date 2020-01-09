class Solution {
    func reverse(_ x: Int) -> Int {
        var n = x
        var result = Int64(0)
        while n != 0 {
            result = result * 10  + Int64(n % 10)
            n /= 10
        }
        return (result < Int32.min || Int32.max < result ?
               0 : Int(result))
    }
}
