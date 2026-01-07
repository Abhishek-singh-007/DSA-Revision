class Solution {
    long MOD = 1000000007L;
    long ans = 0;

    private long dfs(TreeNode node) {
        if (node == null) return 0;

        node.val += dfs(node.left) + dfs(node.right);
        return node.val;
    }

    public int maxProduct(TreeNode root) {
        long total = dfs(root);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) continue;

            long cur = (total - node.val) * node.val;
            ans = Math.max(ans, cur);

            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }

        return (int)(ans % MOD);
    }
}