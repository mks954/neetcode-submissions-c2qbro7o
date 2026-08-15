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
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode s = head;
        ListNode f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }

        ListNode curr1 = head;
        ListNode curr2 = reverse(s.next);
        s.next = null;

        while(curr2 != null){
            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;
            curr1.next = curr2;
            curr2.next = temp1;
            curr1 = temp1;
            curr2 = temp2;
        }

        return;
    }
}
