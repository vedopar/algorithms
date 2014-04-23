/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /*
    * n could exceeds the length of list, so in the first iteration
    * of n, check if @iter1 is reaching the end, if so, @iter1=head;
    * Then iterate @iter2 and get new head in @iter.next;
    */
    public ListNode rotateRight(ListNode head, int n) {
        assert(n>=0);
        if(head==null || head.next==null) return head;
        ListNode iter1=head;
        ListNode iter2=head;
        for(int i=0;i<n;i++) {
            if(iter1.next==null) iter1=head;
            else iter1=iter1.next;
        }
        if(iter1==head) return head;
        while(iter1.next!=null){
            iter1=iter1.next;
            iter2=iter2.next;
        }
        ListNode new_head=iter2.next;
        iter2.next=null;
        iter1.next=head;
        return new_head;
    }
}
