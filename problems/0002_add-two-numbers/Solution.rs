// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let (mut _l1, mut _l2) = (l1, l2);
        let mut head = ListNode::new(0);
        let mut ptr = &mut head;
        let mut carry = 0;
        while _l1 != None || _l2 != None {
            let sum = (if let Some(_l1_) = _l1 {
                _l1 = _l1_.next;
                _l1_.val
            } else { 0 }) + (if let Some(_l2_) = _l2 {
                _l2 = _l2_.next;
                _l2_.val
            } else { 0 }) + carry;
            ptr.next = Some(Box::new(ListNode::new(sum % 10)));
            ptr = ptr.next.as_mut()?.as_mut();
            carry = (if sum >= 10 { 1 } else { 0 });
        }
        if carry == 1 {
            ptr.next = Some(Box::new(ListNode::new(1)));
        }
        head.next
    }
}
