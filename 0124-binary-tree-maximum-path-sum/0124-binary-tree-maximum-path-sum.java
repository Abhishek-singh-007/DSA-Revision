class Solution {
    int total = Integer.MIN_VALUE;
    int helper(TreeNode node){
        if(node == null)return 0;
        int left=helper(node.left);
        int right=helper(node.right);
        left=Math.max(0,left);
        right=Math.max(0,right);
        int sum=left+right+node.val;   // return compare of both side sum
        total=Math.max(total,sum);    // return path of individual nodes
        return Math.max(left,right)+node.val;  // return parents
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return total;
    }
}