/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
        var (_l1, _l2) = (l1, l2)
        val head = ListNode(0)
        var ptr = head
        var carry = 0
        while (_l1 != null || _l2 != null) {
            val sum = (if (_l1 != null) {
                val x = _l1.x
                _l1 = _l1.next
                x
            } else 0) + (if (_l2 != null) {
                val x = _l2.x
                _l2 = _l2.next
                x
            } else 0) + carry
            ptr.next = ListNode(sum % 10)
            ptr = ptr.next
            carry = (if (sum >= 10) 1 else 0)
        }
        if (carry == 1)
            ptr.next = ListNode(1)
        head.next
    }
}
