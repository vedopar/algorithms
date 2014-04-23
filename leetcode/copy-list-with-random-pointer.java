/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /*
    * The question is easy, but the solution below solves it in-place.
    */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode iter=head;
        while(iter!=null){
            RandomListNode copy=new RandomListNode(iter.label);
            copy.next=iter.next;
            iter.next=copy;
            iter=copy.next;
        }
        iter=head;
        while(iter!=null){
            if(iter.random!=null) iter.next.random=iter.random.next;
            iter=iter.next.next;
        }
        iter=head;
        RandomListNode head2=iter.next;
        while(iter!=null){
            RandomListNode copy=iter.next;
            iter.next=copy.next;
            if(copy.next!=null) copy.next=copy.next.next;
            iter=iter.next;
        }
        return head2;
    }
}
