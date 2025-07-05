class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(int n:arr){
            ans.put(n,ans.getOrDefault(n,0)+1);
        }
        int lucky=-1;
        for(int val:ans.keySet()){
            if(ans.get(val)==val){
                lucky=val;
            }
        }
        return lucky;
    }
}