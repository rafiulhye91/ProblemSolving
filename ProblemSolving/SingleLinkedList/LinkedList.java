import java.util.*; 

public class LinkedList{
    
     public static void main(String []args){
        LinkedList list = new LinkedList();
        
        list.insertIntoList(5, list);
        list.insertIntoList(3, list);
        list.insertIntoList(2, list);
        list.insertIntoList(5, list);
        list.insertIntoList(6, list);
        list.insertIntoList(9, list);
        list.traverseList(list);
        
        //list.removeDuplicates(list);
        //list.traverseList(list);
        
        //System.out.println(list.findNthToTheLast(list, 8));
        
        // int i=0;
        // Node currentNode= list.head;
        // while(true){
        //     if(i==2){
        //         System.out.println("Is node deleted: "+list.deleteANode(currentNode));
        //         break;
        //     }
        //     currentNode=currentNode.next;
        //     i++;
        // }
        // list.traverseList(list);
        
        
        // list.insertIntoList(5, list);
        // Node node1=list.insertIntoList(3, list);
        // list.insertIntoList(2, list);
        // list.insertIntoList(5, list);
        // Node node2=list.insertIntoList(6, list);
        // list.insertIntoList(9, list);
        // node2.next = node1;
        // System.out.println("Has any loop: "+list.hasLoop(list));
        
        list.reverseLinkedList(list);
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

    private Node insertIntoList(int data, LinkedList list){
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

    private void  traverseList(LinkedList list){
        Node currentNode = list.head;
        while(currentNode.next!=null){
            System.out.print(currentNode.data+"--->");
            currentNode = currentNode.next;
        }
        System.out.println(currentNode.data);
    }
    
    //with additional space (Hashtable)
    private LinkedList removeDuplicates(LinkedList list){
        if(list==null || list.head.next==null){
            return list;
        }
        Hashtable table = new Hashtable();
        
        Node previousNode = null;
        
        Node currentNode = list.head;
        
        while(currentNode!=null){
            if(table.containsKey(currentNode.data)){
                previousNode.next = currentNode.next;
            }else{
                table.put(currentNode.data, true);
                previousNode=currentNode;
            }
            currentNode= currentNode.next;
        }
        
        return list;
        
    }
    
    private String findNthToTheLast(LinkedList list, int n){
        
        Node fasterNode = list.head;
        
        for (int i =0; i<n; i++){
            if(fasterNode==null){
                return "No Such node exists!";
            }
            fasterNode = fasterNode.next;
        }
        
        Node slowerNode = list.head;
        
        while(fasterNode!=null){
            fasterNode=fasterNode.next;
            slowerNode=slowerNode.next;
        }
        String result = n+": element is "+ slowerNode.data;
        return result;
    }
    
    // deleting a particular given node, you can't delete it if it is the last node 
    private boolean deleteANode(Node n){
        if(n==null || n.next==null){
            return false;
        }
        
        Node node = n.next;
        n.data = node.data;
        n.next=node.next;
        
        return true;
    }
    
    private boolean hasLoop(LinkedList list){
        Node fasterNode = list.head;
        Node slowerNode = list.head;
        
        while(fasterNode.next!=null){
            slowerNode = slowerNode.next;
            fasterNode = fasterNode.next.next;
            
            if(slowerNode == fasterNode){
                return true;
            }
        }
        
        return false;
    }
    
    private void reverseLinkedList(LinkedList list){
        Node prev = null; 
        Node current = list.head; 
        Node next = null; 
        while (current != null) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
        } 
        list.head = prev; 
        
    }
    
}