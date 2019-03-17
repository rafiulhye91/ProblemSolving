
/**
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of 
nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class KGroup{
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode current = head;
        ListNode previous = null;
    
        while(true){
            ListNode temp = getNextStartingNodeToReverse(current, k);
            
            if(current == head){
                current = getReverseList(current, k);
                head = current;
            }
            else{
                current = getReverseList(current, k);
                if(previous!=null){
                    previous.next = current;
                }
            }
            
            if(temp==null){
                break;
            }
            
            previous = current;
            while(previous!=null && previous.next!=null){
                previous=previous.next;
            }            
            current = temp;
        }
        return head;
    }
    
    private ListNode getNextStartingNodeToReverse(ListNode node, int k){
        ListNode temp = node;
        for(int i=1; i<=k;i++){
                if(temp==null){
                    break;
                }
                temp=temp.next;
            }
        return temp;            
    }
    
    private ListNode getReverseList(ListNode head, int k){
        ListNode prev = null; 
        ListNode current = head; 
        ListNode next = null; 
        int i=0;
        while (current != null && i<k) {
            current= current.next;
            i++;
        }
        if(i<k){
            return head;
        }
        
        i=1;
        current = head;
        while (current != null && i<=k) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
            i++;
        } 
        
        current = null;
        head = prev;
        return head;
    }

}
