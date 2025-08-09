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
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null) return null;

        // Step 1: Check if there are at least k ListNodes ahead
        ListNode check = head;
        int count = 0;
        while (check != null && count < k) {
            check = check.next;
            count++;
        }

        // If ListNodes < k, return head without reversing
        if (count < k) return head;

        // Step 2: Reverse exactly k ListNodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        count = k;
        while (curr != null && count > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count--;
        }

        // Step 3: Recursively process the rest
        head.next = reverseKGroup(next, k);

        // prev is the new head of this reversed block
        return prev;
    }
}