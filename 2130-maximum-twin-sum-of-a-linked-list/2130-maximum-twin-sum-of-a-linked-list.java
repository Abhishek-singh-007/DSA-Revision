class Solution {
     public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode after=null;
        while(curr!=null){
            after=curr.next;
            curr.next=prev;
            prev=curr;
            curr=after;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=reverse(slow.next);
        int mxsum=Integer.MIN_VALUE;
        ListNode p1=head;
        ListNode p2=slow.next;
        while(p2!=null){
            if(p1.val+p2.val > mxsum){
                mxsum=p1.val+p2.val;
            }
            p1=p1.next;
            p2=p2.next;
        }
        return mxsum;
    }
}