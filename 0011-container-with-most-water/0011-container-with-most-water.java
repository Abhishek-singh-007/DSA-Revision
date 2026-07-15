class Solution {
    public int maxArea(int[] arr) {
        //[1 8 6 2 5 4 8 3 7]
        int n = arr.length;
        int left = 0;
        int right = n-1;
        int mxHeight = 0;
        while(left < right){
            // jo choota hoga uska length * right-left which is width
            int currArea = Math.min(arr[left],arr[right]) * (right-left);
            mxHeight = Math.max(mxHeight, currArea);
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return mxHeight;
    }
}