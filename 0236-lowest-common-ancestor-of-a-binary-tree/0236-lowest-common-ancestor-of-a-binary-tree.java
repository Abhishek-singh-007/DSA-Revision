class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)return null;
        // 1st case root is p and q then root is the answer
        if(root == p || root == q)return root;
        // maan loh left mai p and right mai q maila toh jo root bgl mai hoga wo answer
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)return root;
        // 3rd maan loh left mai p mila hai right mai q nhi milla toh fix hai left ke neece wala mai q hoga toh automatic left hi ans hua.
        return left == null ? right : left;
    }
}