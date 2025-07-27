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
class Solution {
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        // return good nodes from left subtree + right subtree + 1(for the root itself)
        return count(root.left,root.val) + count(root.right,root.val) + 1;  
    }

    private int count(TreeNode root, int max){
        if(root == null) return 0;

        if(root.val < max){   // if value is less than max , return good nodes from left subtree + right subtree
            return count(root.left,max) + count(root.right,max);
        }
        // else return good nodes from left subtree + right subtree + 1(for the root itself)
        // also update the max to the value of that node
        return count(root.left,root.val) + count(root.right,root.val) + 1;
    }
}