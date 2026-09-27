class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return ans;
    }
    int helper(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        
        // negative number ignore
        left = Math.max(0, left);
        right = Math.max(0, right);

        int pathSum = left + right + node.val;

        ans = Math.max(ans, pathSum);
        
        return Math.max(left, right) + node.val;
    }
}