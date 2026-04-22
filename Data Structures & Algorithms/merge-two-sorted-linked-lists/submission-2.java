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
    private void merge(ListNode l1, ListNode l2, ListNode l3){
        if(l1==null && l2 == null){
            return;
        }

        if(l1==null){
            l3.val = l2.val;
            if(l2.next != null){
                l3.next = new ListNode();
                merge(l1,l2.next,l3.next);
            }else{
                return;
            }
        }else if(l2==null){
            l3.val = l1.val;
            if(l1.next != null){
                l3.next = new ListNode();
                merge(l1.next,l2,l3.next);
            }else{
                return;
            }
        }else if(l1.val<l2.val){
            l3.val = l1.val;
            l3.next = new ListNode();
            merge(l1.next, l2, l3.next);
        }else{
            l3.val = l2.val;
            l3.next = new ListNode();
            merge(l1, l2.next, l3.next);
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l3 = null;
        if(list1 == null && list2 == null){
            return l3;
        }
        l3 = new ListNode();
        ListNode ans = l3;
        //list1 = [1,2,4], list2 = [1,3,5]
        //ans = l3 = new Node()
        merge(list1,list2, l3);
        return ans;
    }
}