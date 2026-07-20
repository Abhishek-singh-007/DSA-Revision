class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int buy=arr[0];
        int profit=0;
        for(int i=0; i<n; i++){
            int sell=arr[i]-buy;
            profit=Math.max(profit,sell);
            buy=Math.min(arr[i],buy);
        }
        return profit;
    }
}