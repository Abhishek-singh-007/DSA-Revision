class Solution:
    def isreverse(self, x: int) -> int:
        num = 0
        while x != 0:
            num = num * 10 + x % 10
            x //= 10   
        return num

    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        return self.isreverse(x) == x   
