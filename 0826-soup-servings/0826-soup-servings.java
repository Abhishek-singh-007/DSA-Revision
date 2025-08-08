class Solution {
    // 1. This is our 'memory' bank! Like sticky notes \U0001f4dd to remember answers we've already figured out.
    private double[][] dp; 

    public double soupServings(int n) {
        // 2. If we have *TONS* of soup, it's practically certain Soup A will run out eventually. So, let's just say it's 100% likely. \U0001f680 This is like saying "If I have a swimming pool of soup, I'm pretty sure I'll empty it sooner or later."
        if (n > 4800) return 1.0; 

        // 3.  We "shrink" the problem! Since the smallest serving is 25ml, let's divide everything by 25. This makes our calculations smaller and faster. \U0001f3c3
        int scaledN = (int) Math.ceil(n / 25.0); 
        
        // 4. Time to set up our memory bank! This is a grid (2D array) where we'll keep track of the results.
        dp = new double[scaledN + 1][scaledN + 1]; 
        
        // 5. Let's get cooking! We're starting the process to find the probability of Soup A running out first.
        return serve(scaledN, scaledN); 
    }

    // This is the heart of the algorithm - where the magic happens! ✨
    private double serve(int a, int b) {
        // 6. If we're OUT of soup A *AND* OUT of soup B at the same time, it's a 50/50 split (half the probability).
        if (a <= 0 && b <= 0) return 0.5; 
        
        // 7. If we're OUT of soup A *BUT* still have soup B, then A ran out first! \U0001f973
        if (a <= 0) {
            return 1.0; // Guaranteed!
        }
        // 8. If we're OUT of soup B *BUT* still have soup A, then A DIDN'T run out first! \U0001f641
        if (b <= 0) {
            return 0.0; // No chance!
        }

        // 9.  Have we already calculated this situation before? If so, let's just grab the answer from our memory! \U0001f9e0
        if (dp[a][b] != 0) { // Since dp array is initialized with 0.0 by default
            return dp[a][b]; // Sweet! We're saving time.
        }

        // 10. If we don't know the answer yet, let's figure it out!
        //    We have 4 possible "serving plans" (like picking a lottery number \U0001f3b0)
        //    Each one has a 25% chance of happening.
        dp[a][b] = 0.25 * (
            serve(a - 4, b) +   // Serve 100ml of A, 0 of B
            serve(a - 3, b - 1) + // Serve 75ml of A, 25 of B
            serve(a - 2, b - 2) + // Serve 50ml of A, 50 of B
            serve(a - 1, b - 3)      // Serve 25ml of A, 75 of B
        );

        // 11.  Save the answer in our memory bank for later!
        return dp[a][b]; // Okay, we're done with this one. \U0001f973
    }
}