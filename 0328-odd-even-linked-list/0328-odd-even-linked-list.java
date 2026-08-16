class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode even=new ListNode(0);
        ListNode odd=new ListNode(0);
        ListNode var1=odd;
        ListNode var2=even;
        ListNode temp=head;
        while(temp!=null){
                var1.next=temp;
                temp=temp.next;
                var1=var1.next;
              
                var2.next=temp;
                if(temp==null) break;
                temp=temp.next;
                var2=var2.next;
        }
        even=even.next;
        odd=odd.next;
        var1.next=even;
        return odd;
    }
}