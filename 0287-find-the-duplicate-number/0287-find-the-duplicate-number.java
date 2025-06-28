class Solution {
    public int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i+1] == arr[i]){
                return arr[i+1];
            }
        }
        return -1;
    }
}