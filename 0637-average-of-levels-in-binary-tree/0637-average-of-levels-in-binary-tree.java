class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            double avg=0;
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                avg += curr.val;
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            avg /= size;
            ans.add(avg);
        }
        return ans;
    }
}