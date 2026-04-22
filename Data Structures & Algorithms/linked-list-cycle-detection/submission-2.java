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
        HashMap<Integer,Integer> mp = new HashMap<>();
        while(head.next != null){
            if(mp.containsKey(head.val)){
                return true;
            }else{
                mp.put(head.val, 1);
            }
            head = head.next;
        }
        return false;
    }
}
