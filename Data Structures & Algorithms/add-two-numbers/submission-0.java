/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null || l2 != null || carry != 0){
            curr.next = new ListNode();
            curr = curr.next;
            int sum;
            if(l1==null && l2==null){
                sum = carry;
            }else if(l1 == null){
                sum = l2.val + carry;
            }else if(l2 == null){
                sum = l1.val + carry;
            }
            else{
                sum = l1.val + l2.val + carry;
            }
            curr.val = sum%10;
            carry = sum/10;
            l1 = l1 != null? l1.next : null;
            l2 = l2 != null? l2.next : null;
        }
        return dummy.next;
    }
}
