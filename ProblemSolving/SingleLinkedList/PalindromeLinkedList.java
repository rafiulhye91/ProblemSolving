/*
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeLinkedList{
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next == null){
            return true;
        }
        ListNode newNode = new ListNode(0);
        ListNode newHead = newNode;
        ListNode current = head;
        while(current!=null){
            newNode.next = getANewNode(current.val);
            current= current.next;
            newNode=newNode.next;
        }
        newNode.next=null;
        ListNode revresedNode = reverseLinkedList(head);
        current=newHead.next;
        while(current!=null){
            if(current.val != revresedNode.val){
                return false;
            }
            current=current.next;
            revresedNode=revresedNode.next;
        }
        return true;
    }
    
     private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null; 
        ListNode current = head; 
        ListNode next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        head = prev; 
        return head;  
         
    }
    
    private ListNode getANewNode(int value){
        return new ListNode(value);
    }
    

}