class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummy = new ListNode(0); // created dummy node
        dummy.next = head;
        ListNode prev=dummy;
        ListNode curr=head;
        for(int i=0; i< left-1; i++){
            prev=prev.next;
            curr=curr.next;
        }
//step 3. point a node where we in last join the reverse part and where we reverse start
         ListNode sublist=curr;
         ListNode pre=null;
         for(int i=0; i < right-left+1; i++){
             ListNode next=curr.next;
             curr.next=pre;
             pre=curr;
             curr=next;
         }
         // step 4.  join the piece
         prev.next=pre;
         sublist.next=curr;
         return dummy.next;
    }
}