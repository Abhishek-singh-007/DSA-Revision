class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid  = (low + high)/2;
            // case 1. if mid is target
            if(nums[mid]==target){
                return mid;
            }
            // case 2. if target is in left
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target < nums[mid]){
                    high = mid-1;
                }else{
                    low = mid + 1;
                }
            }else{
                // case 3. if target is in right side
                if(nums[mid] < target && target <= nums[high]){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}