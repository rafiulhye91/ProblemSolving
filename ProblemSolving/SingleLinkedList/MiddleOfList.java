/*
Given a non-empty, singly linked list with head node head, return a middle node of linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: [1,2,3,4,5]
Output: Node 3 from this list (Serialization: [3,4,5])
The returned node has value 3.  (The judge's serialization of this node is [3,4,5]).
Note that we returned a ListNode object ans, such that:
ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, and ans.next.next.next = NULL.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MiddleOfList{
    public ListNode middleNode(ListNode head) {
        if(head ==null){
            return head;
        }
        
        ListNode faster = head;
        ListNode slower = head;
        
        while(faster!=null && faster.next !=null){
            faster=faster.next.next;
            slower= slower.next;
        }
        
        return slower;        
    }
}