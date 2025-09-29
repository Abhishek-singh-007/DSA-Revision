import java.util.Arrays;
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int C = nums[i];
            int B = nums[i - 1];
            int A = nums[i - 2];
            if (A + B > C) {
                int perimeter = A + B + C;
                return perimeter;
            }
        }
        return 0;
    }
}