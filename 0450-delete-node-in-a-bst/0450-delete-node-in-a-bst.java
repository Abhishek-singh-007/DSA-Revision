class Solution {
    public static TreeNode fis(TreeNode root){
        while(root.left!=null){
            root= root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
       if(root==null){
           return root;
       }
        if(root.val<key){
            root.right= deleteNode(root.right,key);
        }else if(root.val>key){
            root.left= deleteNode(root.left,key);
        }else{
            if(root.right==null && root.left==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            TreeNode IS= fis(root.right);
            root.val= IS.val;
            root.right= deleteNode(root.right, IS.val);
        }
        return root;
    }
}