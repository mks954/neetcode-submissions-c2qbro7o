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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode grpprev = dummy;
        while(true){
            ListNode kth = getk(grpprev,k);
            if(kth == null){
                break;
            }
            ListNode curr = grpprev.next;
            ListNode grpnext = kth.next;
            ListNode prv = kth.next;
            while(curr != grpnext){
                ListNode tmp = curr.next;
                curr.next = prv;
                prv = curr;
                curr = tmp;
            }

            ListNode tmp = grpprev.next;
            grpprev.next = kth;
            grpprev = tmp;
        }
        return dummy.next;
    }

    private ListNode getk(ListNode curr, int k){
        while(curr != null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
