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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode>deque  = new LinkedList<>();
        deque.add(root);
        boolean reverse = false;
        while(!deque.isEmpty()){
            int levelsize  = deque.size();
            List<Integer> currlevel  = new ArrayList<>(levelsize);
            for(int i = 0; i< levelsize; i++){
                if(!reverse){
                    TreeNode currNode = deque.pollFirst();
                    currlevel.add(currNode.val);
                    if(currNode.left != null){
                        deque.addLast(currNode.left);
                    }
                    if(currNode.right != null){
                        deque.addLast(currNode.right);
                    }
                }
                else{
                     TreeNode currNode = deque.pollLast();
                     currlevel.add(currNode.val);
                    if(currNode.right != null){
                        deque.addFirst(currNode.right);
                    }
                    if(currNode.left != null){
                        deque.addFirst(currNode.left);
                    }
                }
                // switch reverse = not reverse vice versa 
            }
            reverse = !reverse;
            result.add(currlevel);
        }
        return result;
    }
}