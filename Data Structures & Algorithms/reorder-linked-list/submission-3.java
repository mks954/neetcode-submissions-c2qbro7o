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
    private ListNode left;
    public ListNode rec(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode right = rec(head.next);
        if(left == right || left.next == right){
            return right;
        }
        ListNode temp = left.next;//4
        this.left.next = right;//2->8
        right.next = temp;//8->4
        this.left = temp;//4
        return head;//6
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        this.left = head;
        ListNode last = rec(head);
        last.next = null;
    }
}
