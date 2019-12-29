/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0),
                ptr = head;
        int carry = 0;
        for (bool g1 = (l1 != null), g2 = (l2 != null);
                g1 || g2;
                g1 = (l1 != null), g2 = (l2 != null)) {
            int sum = (g1 ? l1.val : 0) + (g2 ? l2.val : 0) + carry;
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
