/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) 
    {
        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        helper(root, count, ans);
        return ans;
    }
    private String helper(TreeNode root, Map<String, Integer> count, List<TreeNode> ans)
    {
        if (root == null)
            return "";
        
        final String helper = root.val + "#" + helper(root.left, count, ans) + "#" + helper(root.right, count, ans);
        count.merge(helper, 1, Integer::sum);
       
        if (count.get(helper) == 2)
            ans.add(root);
        return helper;
    }
}