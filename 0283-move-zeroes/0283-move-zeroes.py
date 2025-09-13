class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        count=0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i],nums[count]=nums[count],nums[i]
                count +=1
        