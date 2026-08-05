class Solution {
    public int splitArray(int[] weights, int days) {
        int low = 0;
        int high = 0;
        // Search Space
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int daysUsed = 1;
            int load = 0;
            for (int weight : weights) {
                if (load + weight <= mid) {
                    load += weight;
                } else {
                    daysUsed++;
                    load = weight;
                }
            }
            if (daysUsed <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}