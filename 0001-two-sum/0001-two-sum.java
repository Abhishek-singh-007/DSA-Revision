class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer,Integer> mp = new HashMap<>();
        int[] ans={-1};
        for(int i=0; i<nums.length; i++){
            int partner=target-nums[i];
            if(mp.containsKey(partner)){
                ans=new int[]{i,mp.get(partner)};
                return ans;
            }else{
                mp.put(nums[i],i);
            }
        }
        return ans;
    }
}