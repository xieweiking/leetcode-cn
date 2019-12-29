/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

inline struct ListNode* new_ListNode(const int val) {
    struct ListNode* ptr = malloc(sizeof(struct ListNode));
    ptr->val = val;
    ptr->next = NULL;
    return ptr;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    const struct ListNode head = { .val = 0, .next = NULL };
    struct ListNode* ptr = &head;
    int carry = 0;
    for (bool g1 = (l1 != NULL), g2 = (l2 != NULL);
            g1 || g2;
            g1 = (l1 != NULL), g2 = (l2 != NULL)) {
        const int sum = (g1 ? l1->val : 0) + (g2 ? l2->val : 0) + carry;
        ptr->next = new_ListNode(sum % 10);
        ptr = ptr->next;
        carry = (sum >= 10 ? 1 : 0);
        if (g1)
            l1 = l1->next;
        if (g2)
            l2 = l2->next;
    }
    if (carry == 1)
        ptr->next = new_ListNode(1);
    return head.next;
}
