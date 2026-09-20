class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=0; i<s.length();i++){
            int val='z'-s.charAt(i)+1;
            ans += val*(i+1);
        }
        return ans;
    }
}