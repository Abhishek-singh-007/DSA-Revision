class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q  =new LinkedList<>();
        if(root == null)return ans;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode curr=q.poll();
                if(i==size-1){
                    ans.add(curr.val);
                }
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right);
            }
        }
        return ans;
    }
}