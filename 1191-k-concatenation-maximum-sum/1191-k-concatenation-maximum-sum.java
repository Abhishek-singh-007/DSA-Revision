class Solution {

    int MOD = 1000000007;

    public int kadane(int[] nums) {
        long curr = 0;
        long max = 0;

        for (int x : nums) {
            curr = Math.max(0, curr + x);
            max = Math.max(max, curr);
        }

        return (int) max;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {

        if (k == 1)
            return kadane(arr);

        int n = arr.length;

        int[] twice = new int[2 * n];

        long total = 0;

        for (int i = 0; i < n; i++) {
            twice[i] = arr[i];
            twice[i + n] = arr[i];
            total += arr[i];
        }

        long ans = kadane(twice);

        if (total > 0) {
            ans += (long)(k - 2) * total;
        }

        return (int)(ans % MOD);
    }
}