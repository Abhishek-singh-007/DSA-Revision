class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushleft(root);
    }
    private void pushleft(TreeNode root){
        while(root != null){
            st.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        TreeNode curr=st.pop();
        if(curr.right != null){
            pushleft(curr.right);
        }
        return curr.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}