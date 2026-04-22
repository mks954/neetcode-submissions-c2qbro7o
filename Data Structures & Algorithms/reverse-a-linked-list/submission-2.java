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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode nxt = head.next;//1
        head.next = null;
        while(nxt != null){//1!=null,2!=null,3!= null,null!=null false
            ListNode curr = nxt;//1,2,3
            nxt = nxt.next;//2,3,null
            curr.next = head;//1->0,2->1,3->2
            head = curr;//1,2,3
        }
        return head; //3
    }
}