/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public var val: Int
 *     public var next: ListNode?
 *     public init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */
class Solution {
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var (_l1, _l2) = (l1, l2)
        let head = ListNode(0)
        var ptr = head
        var carry = 0
        var (g1, g2) = (_l1 != nil, _l2 != nil)
        while g1 || g2 {
            let sum = (g1 ? _l1!.val : 0) + (g2 ? _l2!.val : 0) + carry
            let next = ListNode(sum % 10)
            ptr.next = next
            ptr = next
            carry = (sum >= 10 ? 1 : 0)
            if g1 {
                _l1 = _l1!.next
            }
            if g2 {
                _l2 = _l2!.next
            }
            (g1, g2) = (_l1 != nil, _l2 != nil)
        }
        if carry == 1 {
            ptr.next = ListNode(1)
        }
        return head.next
    }
}
