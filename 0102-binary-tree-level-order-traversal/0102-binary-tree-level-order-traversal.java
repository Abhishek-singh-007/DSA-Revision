class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result  = new ArrayList<>();
        if(root == null){
            return result;
        }

            Queue <TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while(!queue.isEmpty()){
                int levelsize = queue.size();
                List<Integer> currlevel  = new ArrayList<>();
                for(int i=0; i < levelsize; i++){
                    TreeNode currentNode = queue.poll();
                    currlevel.add(currentNode.val);
                    if(currentNode.left != null){
                        queue.add(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.add(currentNode.right);
                    }
                }
                result.add(currlevel);
            }
        
        return result;
    }
}