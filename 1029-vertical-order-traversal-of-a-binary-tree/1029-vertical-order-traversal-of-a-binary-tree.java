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
   public class pair implements Comparable<pair>{
    TreeNode node;
    int w;
    int d;
    pair(TreeNode node, int w, int d){
        this.node = node;
        this.w = w;
        this.d = d;
    }
    public int compareTo(pair o){
        if(this.d==o.d){
            return this.node.val-o.node.val;
        }else{
            return this.d-o.d;
        }
    }
}
public List<List<Integer>> verticalTraversal(TreeNode root) {
    Queue<pair> qu = new LinkedList<>();
    HashMap<Integer,ArrayList<pair>> map = new HashMap<>();
    qu.add(new pair(root,0,1));
    int lmw = 0; //left-most width
    int rmw = 0; //right-most width
    while(qu.size()>0){
        pair rem = qu.remove();
        if(rem.w>rmw){
            rmw = rem.w;
        }
        if(rem.w<lmw){
            lmw = rem.w;
        }
        
        if(map.containsKey(rem.w)==false){
            map.put(rem.w,new ArrayList<>());
            map.get(rem.w).add(rem);
        }else{
            map.get(rem.w).add(rem);
        }
        
        if(rem.node.left!=null){
            qu.add(new pair(rem.node.left,rem.w-1,rem.d+1));
        }
        if(rem.node.right!=null){
            qu.add(new pair(rem.node.right,rem.w+1,rem.d+1));
        }
    }
    List<List<Integer>> ans = new ArrayList<>();
    for(int i = lmw; i<=rmw; i++){
        ArrayList<pair> sublist = map.get(i);
        Collections.sort(sublist);
        List<Integer> al = new ArrayList<>();
        for(pair p : sublist){
            al.add(p.node.val);
        }
        ans.add(al);
    }
    return ans;
}
}