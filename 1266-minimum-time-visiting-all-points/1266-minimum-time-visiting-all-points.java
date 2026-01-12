class Solution {
    static int maxNorm(int[] P, int[] Q){
        return Math.max(Math.abs(P[0]-Q[0]), Math.abs(P[1]-Q[1]));
    }
    static public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        int[] prev=points[0];
        for (int[] P: points){
            ans+=maxNorm(P, prev);
            prev=P;
        }
        return ans;
    }
}