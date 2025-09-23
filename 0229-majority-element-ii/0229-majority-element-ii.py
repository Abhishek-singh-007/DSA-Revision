from typing import List
class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        cand1, cand2, c1, c2 = None, None, 0, 0
        # Step 1: Find potential candidates
        for num in nums:
            if num == cand1:
                c1 += 1
            elif num == cand2:
                c2 += 1
            elif c1 == 0:
                cand1, c1 = num, 1
            elif c2 == 0:
                cand2, c2 = num, 1
            else:
                c1 -= 1
                c2 -= 1
        # Step 2: Verify candidates
        res = []
        n = len(nums)
        if cand1 is not None and nums.count(cand1) > n // 3:
            res.append(cand1)
        if cand2 is not None and cand2 != cand1 and nums.count(cand2) > n // 3:
            res.append(cand2)
        return res
