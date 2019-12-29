<?php
/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val) { $this->val = $val; }
 * }
 */
class Solution {
    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2) {
        $head = new ListNode(0);
        $ptr = $head;
        $carry = 0;
        for ($g1 = ($l1 != null), $g2 = ($l2 != null);
                $g1 || $g2;
                $g1 = ($l1 != null), $g2 = ($l2 != null)) {
            $sum = ($g1 ? $l1->val : 0) + ($g2 ? $l2->val : 0) + $carry;
            $ptr->next = new ListNode($sum % 10);
            $ptr = $ptr->next;
            $carry = ($sum >= 10 ? 1 : 0);
            if ($g1)
                $l1 = $l1->next;
            if ($g2)
                $l2 = $l2->next;
        }
        if ($carry == 1)
            $ptr->next = new ListNode(1);
        return $head->next;
    }
}
