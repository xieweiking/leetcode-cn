#!/usr/bin/ruby

# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    head = ListNode.new(0)
    ptr = head
    carry = 0
    g1, g2 = [l1 != nil, l2 != nil]
    while g1 or g2
        sum = (g1 ? l1.val : 0) + (g2 ? l2.val : 0) + carry
        ptr.next = ListNode.new(sum % 10)
        ptr = ptr.next
        carry = (sum >= 10 ? 1 : 0)
        if g1
            l1 = l1.next
        end
        if g2
            l2 = l2.next
        end
        g1, g2 = [l1 != nil, l2 != nil]
    end
    if carry == 1
        ptr.next = ListNode.new(1)
    end
    return head.next
end
