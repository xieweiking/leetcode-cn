class Solution {
    func isMatch(_ s: String, _ p: String) -> Bool {
        let (sAry, pAry) = (Array(s), Array(p))
        var memo = [[Bool]](
                repeating: [Bool](repeating: false, count: p.count + 1),
                count: s.count + 1)
        memo[s.count][p.count] = true
        for i in stride(from: s.count, through: 0, by: -1) {
            for j in stride(from: p.count - 1, through: 0, by: -1) {
                let matchChar = (i < s.count &&
                        (pAry[j] == sAry[i] || pAry[j] == "."))
                memo[i][j] = (j + 1 < p.count && pAry[j + 1] == "*" ?
                        (memo[i][j + 2] || (matchChar && memo[i + 1][j])) :
                        (matchChar && memo[i + 1][j + 1]))
            }
        }
        return memo[0][0]
    }
}
