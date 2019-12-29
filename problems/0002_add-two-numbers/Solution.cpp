/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head = new ListNode(0);
        ListNode* ptr = head;
        int carry = 0;
        for (bool g1 = (l1 != NULL), g2 = (l2 != NULL);
                g1 || g2;
                g1 = (l1 != NULL), g2 = (l2 != NULL)) {
            const int sum = (g1 ? l1->val : 0) + (g2 ? l2->val : 0) + carry;
            ptr->next = new ListNode(sum % 10);
            ptr = ptr->next;
            carry = (sum >= 10 ? 1 : 0);
            if (g1)
                l1 = l1->next;
            if (g2)
                l2 = l2->next;
        }
        if (carry == 1)
            ptr->next = new ListNode(1);
        return head->next;
    }
};
