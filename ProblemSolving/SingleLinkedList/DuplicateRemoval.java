
/*
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DuplicateRemoval {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }
        
        ListNode newNode = new ListNode(0);
        ListNode newHead = newNode;
        ListNode current = head;
        
        while(current!=null){
            if(current.val != val){
                //System.out.println(current.val);
                newNode.next = current;
                newNode = newNode.next;
            }
            current=current.next;
        }     
        newNode.next= null;
        return newHead.next;
    }
}