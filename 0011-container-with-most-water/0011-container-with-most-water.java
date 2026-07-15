class Solution {
    public int maxArea(int[] arr) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        int mxheight=0;
        while(left<right){
            int currheight=Math.min(arr[left],arr[right])*(right-left);
            mxheight=Math.max(mxheight,currheight);
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return mxheight;
    }
}