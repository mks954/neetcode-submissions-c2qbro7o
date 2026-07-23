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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        //minimum node
        while(true){
            int index = -1;
            for(int i = 0 ; i < lists.length ; i++){
                if(lists[i]==null){
                    continue;
                }
                if(index ==-1 || lists[i].val<lists[index].val){
                    index = i;
                }
            }
            if(index == -1){
                curr = null;
                break;
            }
            curr.next = lists[index];
            curr = curr.next;
            lists[index] = lists[index].next;
        }

        return dummy.next;
    }
}
