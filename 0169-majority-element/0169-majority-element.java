class Solution {
    public int majorityElement(int[] nums) {
        int ans=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                ans=num;
            }
            if(num == ans){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}