class Solution {
       public int numberOfPairs(int[][] A) {
        int res = 0, n = A.length;
        Arrays.sort(A, (a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < n; ++i) {
            int y = -(int)2e9;
            for (int j = i + 1; j < n; ++j) {
                if (A[i][1] >= A[j][1] && A[j][1] > y) {
                    res++;
                    y = A[j][1];
                }
            }
        }
        return res;
    }
}