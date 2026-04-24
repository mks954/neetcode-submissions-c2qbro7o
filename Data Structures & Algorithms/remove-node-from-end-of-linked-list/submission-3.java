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
    private int k;
    private ListNode left = null;
    private ListNode middle = null;
    private ListNode right = null;
    private void rec(ListNode head){
        if(head == null){
            return;
        }
        if(k<0){
            return;
        }
        rec(head.next);
        if(k==2){
            this.right = head;
        }else if(k==1){
            this.middle = head;
        }else if(k==0){
            this.left = head;
        }
        k--;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.k = n;
        rec(head);
        if(left==null && right==null){
            return left;
        }else if(left == null){
            return right;
        }else if(right == null){
            left.next = null;
            return head;
        }
        left.next = right;
        return head;
    }
}
