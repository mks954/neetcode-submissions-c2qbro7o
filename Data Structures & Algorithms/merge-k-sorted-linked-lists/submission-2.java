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
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val<=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1!= null) curr.next = l1;
        if(l2!= null) curr.next = l2;
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0){
            return null;
        }else if(n==1){
            return lists[0];
        }
        ListNode ans = merge(lists[0], lists[1]);
        for(int i = 2 ; i < n ; i++){
            ans = merge(ans,lists[i]);           
        }
        return ans;
    }
}
