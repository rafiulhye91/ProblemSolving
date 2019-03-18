/*
Given a linked list, rotate the list to the right by k places, where k is non-negative.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RotateList{
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int lengthOfList = getLength(head);
        k = k%lengthOfList;
        ListNode node=head;
        for(int i =0; i<k; i++){
            node = rotateOnce(node);
        }
        return node;
    }
    
    private ListNode rotateOnce(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        
        while(current.next!=null){
            prev = current;
            current=current.next;
        }
        prev.next = null;
        current.next = head;
        return current;        
    }
    
    private int getLength(ListNode head){
        ListNode current=head;
        int count =1;
        while(current.next!=null){
            count ++;
            current=current.next;
        }
        return count;
    }
}