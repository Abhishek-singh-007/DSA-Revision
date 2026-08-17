class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
     
        while(curr.next != null && curr.next.next !=null){
         ListNode t1=curr.next;
         ListNode t2=curr.next.next;
         t1.next=t2.next;
         t2.next=t1;
         curr.next=t2;
         curr=t1;
        }
        return dummy.next;
    }
}