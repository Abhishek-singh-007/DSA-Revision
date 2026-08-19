class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode a=new ListNode(0);
        ListNode b=new ListNode(0);
        ListNode aa=a;
        ListNode bb=b;
        while(head != null){
            if(head.val<x){
                aa.next=head;
                aa=aa.next;
            }else{
                bb.next=head;
                bb=bb.next;
            }
            head=head.next;
        }
        bb.next=null;
        aa.next=b.next;
        return a.next;
    }
}