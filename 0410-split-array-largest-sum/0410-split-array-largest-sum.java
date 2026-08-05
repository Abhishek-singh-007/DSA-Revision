class Solution {
    public int splitArray(int[] nums, int k) {

        int low = 0;
        int high = 0;

        // Search Space
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int parts = 1;
            int sum = 0;

            for (int num : nums) {

                if (sum + num <= mid) {
                    sum += num;
                } else {
                    parts++;
                    sum = num;
                }
            }

            if (parts <= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}