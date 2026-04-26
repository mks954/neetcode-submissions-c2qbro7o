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
    private void add(ListNode l1, ListNode l2, ListNode l3, int c){
        if(l1==null && l2 == null && c == 0){
            return;
        }
        int v1 = l1 != null ? l1.val : 0;
        int v2 = l2 != null ? l2.val : 0;
        int sum = (v1+v2) + c;
        l3.next = new ListNode(sum%10);
        c = sum/10;
        add(l1 != null ? l1.next : null, l2 != null ? l2.next : null, l3.next, c);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode l3 = dummy;
        add(l1,l2,l3,0);
        return dummy.next;
    }
}
