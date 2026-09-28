class Solution {
      public TreeNode sortedArrayToBST(int[] nums) {
        return CreateBST(nums, 0, nums.length - 1);
    }
    private TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2; 
        TreeNode root = new TreeNode(nums[mid]); 
        root.left = CreateBST(nums, l, mid - 1); 
        root.right = CreateBST(nums, mid + 1, r); 
        return root;
    }
}