class Solution {
    public boolean uniformArray(int[] nums) {
        int smallestOdd = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num % 2 == 1)
                smallestOdd = Math.min(smallestOdd, num);
        }

        // Already all even
        if (smallestOdd == Integer.MAX_VALUE)
            return true;

        // Check whether every even number can become odd
        for (int num : nums) {
            if (num % 2 == 0 && num <= smallestOdd)
                return false;
        }

        return true;
    }
}