/*
Given a singly linked list L: L0->L1->…->Ln-1->Ln,
reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…
You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:
Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:
Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LinedListReorder{
    public void reorderList(ListNode head) {
        if(head == null || head.next==null){
            return;
        }
        ListNode midNode = getMidNode(head);
        ListNode reverseNode = getReverseNode(midNode); 
        
        ListNode current = head;
        ListNode nextActual = null;
        ListNode nextReverse = null;
        while(reverseNode!=null){
            nextActual = current.next;
            nextReverse = reverseNode.next;
            current.next = reverseNode;
            reverseNode.next = nextActual;
            current = nextActual;
            reverseNode = nextReverse;
        }
        if(current!=null){
            current.next = null;
        }
    }
    
    private ListNode getMidNode(ListNode head){
        ListNode faster = head;
        ListNode slower = head;
        while(faster!=null && faster.next!=null){
            faster = faster.next.next;
            slower = slower.next;
        }
        return slower;
    }
    
    private ListNode getReverseNode(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev= current;
            current = next;
        }
        return prev;
    }
}