class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> memo=new HashMap<>();
        return climb(n,memo);
    }
    private int climb(int n, Map<Integer, Integer> memo){
        if(n==0 || n==1)return 1;
        if(!memo.containsKey(n)){
            memo.put(n,climb(n-1,memo)+climb(n-2,memo));
        }
        return memo.get(n);
    }
}