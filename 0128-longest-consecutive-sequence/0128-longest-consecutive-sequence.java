class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> ans = new HashSet<>();
        for(int num:nums){
            ans.add(num);
        }
        int mxlen=0;
        for(int num:ans){
            if(!ans.contains(num-1)){
                int currnum=num;
                int currlen=1;
                while(ans.contains(currnum+1)){
                    currlen++;
                    currnum++;
                }
                mxlen=Math.max(mxlen,currlen);
            }
        }
        return mxlen;
    }
}