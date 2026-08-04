class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> missingNumber = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 1, prevNum = nums[0]; i < nums.length; i++) {
            while (nums[i] != prevNum + 1) {
                missingNumber.add(++prevNum);
            }
            prevNum = nums[i];
        }

        return missingNumber;
    }
}