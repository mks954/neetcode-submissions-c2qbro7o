/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node curr = head;
        //curr
        while(curr != null){
            Node rand = curr.random;
            curr.random = new Node(curr.val);
            curr.random.random = rand;
            curr = curr.next;
        }
        // curr->next;
        curr = head;
        while(curr!=null){
            if(curr.next!=null) curr.random.next = curr.next.random;
            if(curr.random.random != null){
                curr.random.random = curr.random.random.random;
            }
            curr = curr.next;
        }
        return head.random;
    }
}
