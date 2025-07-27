class Solution {
    public int maxSubarraySumCircular(int[] nums) {
      int total=0;
      int currmin=0;
      int currmax=0;
      int max=nums[0];
      int min=nums[0];
      for(int num:nums){
          total+=num;
          currmax=Math.max(currmax+num,num);
          currmin=Math.min(currmin+num,num);
          max=Math.max(currmax,max);
          min=Math.min(currmin,min);
      }
      return max<0?max:Math.max(max,total-min);
    }
}