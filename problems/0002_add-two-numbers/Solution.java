/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final ListNode head = new ListNode(0);
        ListNode ptr = head;
        int carry = 0;
        for (boolean g1 = (l1 != null), g2 = (l2 != null);
                g1 || g2;
                g1 = (l1 != null), g2 = (l2 != null)) {
            final int sum = (g1 ? l1.val : 0) + (g2 ? l2.val : 0) + carry;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
            carry = (sum >= 10 ? 1 : 0);
            if (g1)
                l1 = l1.next;
            if (g2)
                l2 = l2.next;
        }
        if (carry == 1)
            ptr.next = new ListNode(1);
        return head.next;
    }
}
