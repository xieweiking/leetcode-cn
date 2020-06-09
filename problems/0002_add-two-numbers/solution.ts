/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function addTwoNumbers(l1: ListNode | null, l2: ListNode | null): ListNode | null {
    const head = new ListNode(0)
    let ptr = head, carry = 0
    for (let g1 = (l1 != null), g2 = (l2 != null);
            g1 || g2;
            g1 = (l1 != null), g2 = (l2 != null)) {
        const sum = (g1 ? l1!.val : 0) + (g2 ? l2!.val : 0) + carry
        ptr.next = new ListNode(sum % 10)
        ptr = ptr.next
        carry = (sum >= 10 ? 1 : 0)
        if (g1)
            l1 = l1!.next
        if (g2)
            l2 = l2!.next
    }
    if (carry === 1)
        ptr.next = new ListNode(1)
    return head.next
};
