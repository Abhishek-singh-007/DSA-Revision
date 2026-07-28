class Solution {
    public int firstOcc(int[] arr, int target){
        int n = arr.length;
        int s = 0, e = n-1;
        int mid = s + (e-s)/2;
        int ans = -1;
        while(s <= e){
            if(arr[mid] == target){
                ans = mid;
                e = mid - 1;
            }else if(arr[mid] < target){
                s = mid + 1;
            }else if(arr[mid] > target){
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
    public int lastOcc(int[] arr, int target){
        int n = arr.length;
        int s = 0, e = n-1;
        int mid = s + (e-s)/2;
        int ans = -1;
        while(s <= e){
            if(arr[mid] == target){
                ans = mid;
                s = mid + 1;
            }else if(arr[mid] < target){
                s = mid + 1;
            }else if(arr[mid] > target){
                e = mid - 1;
            }
            mid = s + (e-s)/2;
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = firstOcc(nums, target);
        ans[1] = lastOcc(nums, target);
        return ans;
    }
}