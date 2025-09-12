# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1:
            return list2
        if not list2:
            return list1

        # Ensure list1 starts with the smaller head
        if list2.val < list1.val:
            list1, list2 = list2, list1

        head = list1   # merged list head
        prev = None
        t1, t2 = list1, list2

        while t1 and t2:
            if t1.val <= t2.val:
                prev = t1
                t1 = t1.next
            else:
                nextT2 = t2.next
                prev.next = t2
                t2.next = t1
                prev = t2
                t2 = nextT2

        if t2:
            prev.next = t2

        return head
