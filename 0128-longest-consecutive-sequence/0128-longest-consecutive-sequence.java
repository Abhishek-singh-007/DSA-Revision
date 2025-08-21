class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> st= new HashSet<>();
       // put all element in hashset
       for(int num : nums) st.add(num); 
       int mxlength=0;
       // find starting point in st
       for(int num : st){
        if(!st.contains(num-1)){
            int currnum=num;
            int currlength=1;
        // now find the next element in st and update curr length
            while(st.contains(currnum+1)){
                currlength++;
                currnum++;
            }
            // update the currlength into mxlength
            mxlength=Math.max(mxlength , currlength);
        }
    }
       return mxlength;
    }
}