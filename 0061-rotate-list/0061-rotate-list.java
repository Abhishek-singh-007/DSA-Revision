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
    public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next == null)return head;
        ListNode last=head;
        int len=1;
        while(last.next!=null){
            last=last.next;
            len++;
        }
        last.next=head;
        int rot=k%len;
        int step=len-rot;
        ListNode temp=head;
        for(int i=0; i<step-1;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        return head;
    }
}