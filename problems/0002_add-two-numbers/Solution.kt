/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var _l1 = l1
        var _l2 = l2
        val head = ListNode(0)
        var ptr = head
        var carry = 0
        while (_l1 != null || _l2 != null) {
            val sum = (if (_l1 != null) {
                val v = _l1.`val`
                _l1 = _l1.next
                v
            } else 0) + (if (_l2 != null) {
                val v = _l2.`val`
                _l2 = _l2.next
                v
            } else 0) + carry
            ptr.next = ListNode(sum % 10)
            ptr = ptr.next
            carry = (if (sum >= 10) 1 else 0)
        }
        if (carry == 1)
            ptr.next = ListNode(1)
        return head.next
    }
}
