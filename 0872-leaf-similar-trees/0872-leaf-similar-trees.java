
class Solution {

    public void findLeaves(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        // Leaf node check
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        findLeaves(root.left, list);
        findLeaves(root.right, list);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        findLeaves(root1, list1);
        findLeaves(root2, list2);

        return list1.equals(list2);
    }
}
