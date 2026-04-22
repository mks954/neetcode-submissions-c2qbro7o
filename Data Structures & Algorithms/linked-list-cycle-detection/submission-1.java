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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next == null) return false;
        ListNode fptr = head.next;
        ListNode sptr = head;
        while(true){
            if(fptr==sptr){
                return true;
            }
            if(fptr.next == null || fptr.next.next == null){
                return false;
            }else{
                fptr = fptr.next.next;
                sptr = sptr.next;
            }
        }
    }
}
