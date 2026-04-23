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
    public ListNode reverse(ListNode s){
        if(s==null || s.next==null){
            return s;
        }

        ListNode newhead = reverse(s.next);
        s.next.next = s;
        s.next = null;
        return newhead;
    }
    public void reorderList(ListNode head) {
        ListNode fast = head; 
        ListNode slow = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow);

        while(rev.next != null){
            ListNode tmp = head.next;
            ListNode tmp_r = rev.next;
            head.next = rev;
            rev.next = tmp;
            head = tmp;
            rev = tmp_r;
        }
    }
}
