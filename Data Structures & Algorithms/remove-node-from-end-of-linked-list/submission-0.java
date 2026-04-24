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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arr = new ArrayList<>();
        ListNode start = head;
        while(head != null){
            arr.add(head);
            head = head.next;
        }
        int ind = arr.size()-n;
        ListNode left = (ind-1<0) ? null: arr.get(ind-1);
        ListNode right = (ind+1>= arr.size()) ? null: arr.get(ind+1);
        
        if(left==null && right == null){
            return left;
        }else if(right==null){
            left.next = null;
            return start;
        }else if(left==null){
            return right;
        }
        left.next = right;
        arr.get(ind).next = null;
        return start;
    }
}
