/*
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing 
together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeSortedList{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {       
        if(l1==null && l2==null){
            return null;
        }
        
        if(l1==null && l2!=null){
            return l2;
        }
        if(l1!=null && l2==null){
            return l1;
        }
        
        ListNode newNode = new ListNode(0);
        ListNode newHead = newNode;
        
        while(true){
            if(l1==null || l2==null){
                break;
            }
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1<val2){
                newNode.next = l1;
                l1=l1.next;               
            }
            else {
                newNode.next = l2;
                l2=l2.next; 
            }
            newNode = newNode.next;
        }
        
        if(l1!=null){
            newNode.next = l1;
        }
        if(l2!=null){
            newNode.next = l2;
        }
        return newHead.next;        
    }
}