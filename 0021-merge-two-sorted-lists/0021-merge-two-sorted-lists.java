/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Ensure list1 starts with the smaller head so we can return list1 as head
        if (list2.val < list1.val) {
            ListNode tmp = list1;
            list1 = list2;
            list2 = tmp;
        }

        ListNode head = list1;   // the merged list head (smaller of the two starts)
        ListNode prev = null;    // last node in merged part
        ListNode t1 = list1;
        ListNode t2 = list2;

        while (t1 != null && t2 != null) {
            if (t1.val <= t2.val) {
                // t1 is in correct order, move forward
                prev = t1;
                t1 = t1.next;
            } else {
                // t2 node should come before t1: splice t2 between prev and t1
                ListNode nextT2 = t2.next; // keep t2 next
                prev.next = t2;
                t2.next = t1;
                // update prev and t2
                prev = t2;
                t2 = nextT2;
            }
        }

        // If t2 still has nodes, append them
        if (t2 != null) {
            prev.next = t2;
        }

        return head;
    }
}