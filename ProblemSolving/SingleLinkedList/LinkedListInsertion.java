import java.util.*; 

public class LinkedListInsertion{
    
     public static void main(String []args){
        LinkedListInsertion list = new LinkedListInsertion();
        
        list.insertIntoList(5, list);
        list.insertIntoList(3, list);
        list.insertIntoList(2, list);
        list.insertIntoList(5, list);
        list.insertIntoList(6, list);
        list.insertIntoList(9, list);
        list.traverseList(list);
        
        int i=0;
        Node currentNode= list.head;
        while(currentNode!=null){
            if(i==2||i==6){
                Node resulingNode = list.insertInToMiddleOfList1(i+2, list.head, currentNode);
                list.insertInToMiddleOfList2(i+2, currentNode);
                break;
            }
            currentNode=currentNode.next;
            i++;
        }
        list.traverseList(list);
        
     }
     
      Node head = null;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
        }
    }

    private Node insertIntoList(int data, LinkedListInsertion list){
        Node newNode = new Node(data);
        newNode.next = null;
        if(list.head==null){
            list.head = newNode;
            //traverseList(list);
            return newNode;
        }
        
        Node currentNode = list.head;
        while(currentNode.next!=null){
            //System.out.println("currentNode: "+currentNode.data);
            currentNode = currentNode.next;
        }
        
        currentNode.next= newNode;
        //traverseList(list);
        return newNode;
    }

    private void  traverseList(LinkedListInsertion list){
        Node currentNode = list.head;
        while(currentNode.next!=null){
            System.out.print(currentNode.data+"--->");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.data);
    }
    
    // if the root/head of the linked list is provided
    private Node insertInToMiddleOfList1(int data, Node head, Node targetNode){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return head;
        }
        
        Node currentNode = head;
        while(currentNode!=null){
            if(currentNode==targetNode){
                break;
            }
            currentNode=currentNode.next;
        }
        
        if(currentNode==null){
            return null;
        }
        
        Node nextNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next=nextNode;
        return head;
    }
    
    // if the root/head of the linked list is provided
    private Node insertInToMiddleOfList2(int data, Node targetNode){
        Node newNode = new Node(data);
        if(targetNode==null){
            targetNode = newNode;
            return targetNode;
        }
        
        Node nextNode = targetNode.next;
        targetNode.next = newNode;
        newNode.next = nextNode;
        return newNode;
    }
    
}
