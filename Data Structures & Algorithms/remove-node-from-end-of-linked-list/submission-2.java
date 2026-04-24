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
        ListNode node = head;
        Stack<ListNode> st = new Stack<>();
        while(node!=null){
            st.push(node);
            node = node.next;
        }
        // 1 2 3 4
        int k = n; // 2
        ListNode right = null;
        ListNode left = null;
        ListNode middle = null;
        while(k>=0){
            if(k==2){
                if(!st.isEmpty()) right = st.pop();// 4
            }else if(k==1){
                if(!st.isEmpty()) middle = st.pop();// 3
            }else if(k==0){
                if(!st.isEmpty()) left = st.pop();// 2
                break; 
            }else{
                if(!st.isEmpty()) st.pop();
            }
            k--;
        }

        if(left == null && right == null){
            return left;
        }else if(left==null){
            return right;
        }else if(right==null){
            left.next = null;
            return head;
        }else{
            left.next = right;
            return head;
        }
    }
}
