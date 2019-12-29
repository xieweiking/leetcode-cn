/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    head := ListNode { Val: 0 }
    ptr := &head
    carry := 0
    for g1, g2 := l1 != nil, l2 != nil;
            g1 || g2;
            g1, g2 = l1 != nil, l2 != nil {
        sum := carry
        if g1 {
            sum += l1.Val
            l1 = l1.Next
        }
        if g2 {
            sum += l2.Val
            l2 = l2.Next
        }
        ptr.Next = &ListNode { Val: sum % 10 }
        ptr = ptr.Next
        if sum >= 10 {
            carry = 1
        } else {
            carry = 0
        }
    }
    if carry == 1 {
        ptr.Next = &ListNode { Val: 1 }
    }
    return head.Next
}
