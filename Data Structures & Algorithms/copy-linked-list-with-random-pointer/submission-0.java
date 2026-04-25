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
        HashMap<Node, Node> mp = new HashMap<>();
        Node node = head;//3
        while(node != null){
            mp.put(node, new Node(node.val));//{3,3},{7,7},{4,4},{5,5}
            node = node.next;//7,4,5,null
        }
        // old node and new node identity mapping;
        node  = head; // 3
        // old and new node next and random mapping;
        while(node != null){
            Node cnode = mp.get(node);// 3
            Node cnext = mp.containsKey(node.next)? mp.get(node.next): null;//7
            Node crand = mp.containsKey(node.random)? mp.get(node.random): null;// null
            cnode.next = cnext; //{3->7}
            cnode.random = crand; //{3,null}
            node = node.next;
        }

        return mp.get(head);
    }
}
