class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int k = 1;
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[k - 1]) {
                if (cnt < 2) {
                    nums[k] = nums[i];
                    k++;
                    cnt++;
                }
            } else {
                nums[k] = nums[i];
                k++;
                cnt = 1;
            }
        }
        return k;
    }
}
