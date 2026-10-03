class Solution {
    public Node connect(Node root) {
        Node curr = root;

        while (curr != null) {
            // Dummy node helps build the next level
            Node dummy = new Node(0);
            Node tail = dummy;

            // Traverse current level using next pointers
            while (curr != null) {

                // Add left child to next level
                if (curr.left != null) {
                    tail.next = curr.left;
                    tail = tail.next;
                }

                // Add right child to next level
                if (curr.right != null) {
                    tail.next = curr.right;
                    tail = tail.next;
                }

                curr = curr.next;
            }

            // Move to the first node of the next level
            curr = dummy.next;
        }

        return root;
  }
}