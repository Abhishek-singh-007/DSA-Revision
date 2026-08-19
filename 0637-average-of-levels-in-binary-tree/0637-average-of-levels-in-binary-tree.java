class Solution {
     public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result  = new ArrayList<>();
        if(root == null){
            return result;
        }
            Queue <TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int levelsize = queue.size();
                double averagelevel = 0;
                for(int i=0; i < levelsize; i++){
                   TreeNode currentNode = queue.poll();
                   averagelevel += currentNode.val;
                    if(currentNode.left != null){
                        queue.add(currentNode.left);
                    }
                    if(currentNode.right != null){
                        queue.add(currentNode.right);
                    }
                }
                averagelevel = averagelevel / levelsize;
                result.add(averagelevel);
            }
        
        return result;
    }
}