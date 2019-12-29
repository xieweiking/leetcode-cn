#!/usr/bin/python3

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode(0)
        ptr = head
        carry = 0
        g1, g2 = (l1 is not None, l2 is not None)
        while g1 or g2:
            s = (l1.val if g1 else 0) + (l2.val if g2 else 0) + carry
            ptr.next = ListNode(s % 10)
            ptr = ptr.next
            carry = (1 if s >= 10 else 0)
            if g1:
                l1 = l1.next
            if g2:
                l2 = l2.next
            g1, g2 = (l1 is not None, l2 is not None)
        if carry == 1:
            ptr.next = ListNode(1)
        return head.next
