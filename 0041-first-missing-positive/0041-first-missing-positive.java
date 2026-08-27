class Solution {
    public int firstMissingPositive(int[] nums) {
       int n = nums.length;

        // Step 1: Put each number in its right index if it's between 1 and n
        for (int i = 0; i < n; i++) {
            while (
                nums[i] > 0 && nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find the first index i where nums[i] != i+1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all numbers are at correct position
        return n + 1;
    }
}