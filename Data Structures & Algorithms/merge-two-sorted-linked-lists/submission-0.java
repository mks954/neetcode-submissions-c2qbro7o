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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return list1;
        }else if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode list3 = new ListNode();
        if(list1.val<list2.val){
            list3.val = list1.val;
            list1 = list1.next;
        }else{
            list3.val = list2.val;
            list2 = list2.next;
        }

        ListNode head = list3;

        while(list1!=null || list2!=null){
            list3.next = new ListNode();
            if(list1!=null && list2!=null){
                if(list1.val<list2.val){
                    list3.next.val = list1.val;
                    list1 = list1.next;
                    list3 = list3.next;
                }else{
                    list3.next.val = list2.val;
                    list2 = list2.next;
                    list3 = list3.next;
                }
            }else if(list1!=null){
                list3.next.val = list1.val;
                list1 = list1.next;
                list3 = list3.next;
            }else{
                list3.next.val = list2.val;
                list2 = list2.next;
                list3 = list3.next;
            }
        }
        return head;
    }
}