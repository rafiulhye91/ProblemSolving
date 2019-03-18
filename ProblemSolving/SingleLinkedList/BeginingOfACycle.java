/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

To represent a cycle in the given linked list, we use an integer pos which represents the position 
(0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

Note: Do not modify the linked list.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class BeginingOfACycle{
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null){
            return null;
        }
        ListNode slower = head;
        ListNode faster = head;
        
        while(faster!=null && faster.next!=null){
            
            slower = slower.next;
            faster = faster.next.next;
            if(faster==slower){
                break;
            }
        }
        if(faster==null || faster.next==null){
            return null;
        }
        
        slower = head;
        while(slower!=faster){
            slower=slower.next;
            faster=faster.next;
        }
        
        return faster;
    }
}