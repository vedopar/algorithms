/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    * This solution use two iter with different speed to find the middle node,
    * Be careful about the edge conditions.
    */
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode iter2=head.next;
        ListNode iter1=head;
        while(iter2!=null && iter2.next!=null && iter2.next.next!=null){
            iter2=iter2.next.next;
            iter1=iter1.next;
        }
        ListNode middle=iter1.next;
        TreeNode root=new TreeNode(middle.val);
        iter1.next=null;
        root.left=sortedListToBST(head);
        ListNode head2=middle.next;
        middle.next=null;
        root.right=sortedListToBST(head2);
        return root;
    }
}
