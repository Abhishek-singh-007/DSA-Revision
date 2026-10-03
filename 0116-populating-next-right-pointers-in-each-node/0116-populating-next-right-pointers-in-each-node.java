class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node leftmost=root;
        while(leftmost.left != null){
            Node curr=leftmost;
            while(curr != null){
                curr.left.next=curr.right;
                if(curr.next != null){
                    curr.right.next=curr.next.left;
                }
                curr=curr.next;
            }
            leftmost=leftmost.left;
        }
        return root;
    }
}