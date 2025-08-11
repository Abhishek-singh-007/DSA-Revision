class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int) (1e9 + 7);    
        int q = queries.length;   
        List<Integer> powers = new ArrayList<>(); // This is where we'll store our "special ingredients" (powers of 2)

        // Find all the "special ingredients" that make up the number n
        for (int i = 0; i < 31; i++) {         // We only need to check up to 2^30 because n is less than 10^9
            if ((n >> i & 1) == 1)            // Is the i-th bit of n a "1"? If so, this "special ingredient" is used.
/*
In binary, each number is represented as a sum of powers of two,
 where each power of two is either present (if the bit is 1)
 or absent (if the bit is 0)
*/
                powers.add(1 << i);           // Add this "special ingredient" (power of 2) to our list
        }

        int[] ans = new int[q];              // This is where we'll store the "flavor" (product) for each instruction

        // Follow each instruction and find the "flavor"
        for (int i = 0; i < q; i++) {             // For each instruction...
            int left = queries[i][0];          // The starting position of the ingredients we need to use
            int right = queries[i][1];         // The ending position of the ingredients we need to use
            long product = 1;                   // Start with a "base flavor" of 1. We use long to prevent overflow.

            // Mix the ingredients in the given range
            for (int j = left; j <= right; j++)     // Loop through the ingredient positions
                product = (product * powers.get(j)) % MOD;  // Multiply the current "flavor" with the flavor of this ingredient, then limit the flavor to prevent it from getting too strong.

            ans[i] = (int) product;             // Record the final "flavor" for this instruction
        }

        return ans;                             // Return the "flavor" for all instructions
    }
}