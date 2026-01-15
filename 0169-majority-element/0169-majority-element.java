class Solution {
    public int majorityElement(int[] nums) {
        int res=0;
        int cnt=0;
        for(int num : nums){
            if(cnt ==0){
                res=num;
            }
            if(res == num){
                cnt++;
            }else{
                cnt--;
            }
        }        
        return res;
    }
}