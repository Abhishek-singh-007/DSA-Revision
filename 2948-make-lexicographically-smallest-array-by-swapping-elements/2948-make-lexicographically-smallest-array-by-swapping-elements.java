import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        if (n == 0) return new int[0];
        
        // Step 1: Pair each number with its index
        int[][] sortedPairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            sortedPairs[i][0] = nums[i];
            sortedPairs[i][1] = i;
        }
        
        // Step 2: Sort by number value
        Arrays.sort(sortedPairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] result = new int[n];
        int groupStart = 0;
        
        for (int i = 0; i < n; i++) {
            // Step 3: Check if current group ends here
            if (i == n - 1 || sortedPairs[i+1][0] - sortedPairs[i][0] > limit) {
                // Step 4: Collect and sort original indices
                List<Integer> indices = new ArrayList<>();
                for (int j = groupStart; j <= i; j++) 
                    indices.add(sortedPairs[j][1]);
                Collections.sort(indices);
                
                // Step 5: Assign sorted values to sorted indices
                for (int j = 0; j < indices.size(); j++) 
                    result[indices.get(j)] = sortedPairs[groupStart + j][0];
                
                groupStart = i + 1; // Next group
            }
        }
        return result;
    }
}