class Solution {
    public int findLevel(TreeNode root, int target, int level) {
        if (root == null) {
            return -1;
        }
        if (root.val == target) {
            return level;
        }
        int left = findLevel(root.left, target, level + 1);
        if (left != -1) {
            return left;
        }
        return findLevel(root.right, target, level + 1);
    }
    public TreeNode findParent(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if ((root.left != null && root.left.val == target) ||
            (root.right != null && root.right.val == target)) {
            return root;
        }
        TreeNode left = findParent(root.left, target);
        if (left != null) {
            return left;
        }
        return findParent(root.right, target);
    }
    public boolean isSibling(TreeNode root, int x, int y) {
        TreeNode parentX = findParent(root, x);
        TreeNode parentY = findParent(root, y);
        return parentX != null && parentX == parentY;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        int levelX = findLevel(root, x, 0);
        int levelY = findLevel(root, y, 0);
        return levelX == levelY && !isSibling(root, x, y);
    }
}