import java.util.*; 

public class BinarySearchTree{
    
     public static void main(String []args){
        int[] inputs = {100,200,300,400,5,4,9,500,700,4,6,7,30,50,71};
        
        int size = inputs.length;
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for(int i=0; i<size; i++){
            
            Node node =binarySearchTree.insertNode(binarySearchTree.root, inputs[i]);
            //System.out.println(node.value);
        }
        binarySearchTree.printTree(binarySearchTree.root);
     }
     
     class Node {
         int value;
         Node leftNode;
         Node rightNode;
         
         Node(int data){
             value = data;
         }
     }
     
     Node root = null;
     
     private Node insertNode(Node root, int value){
         
         if(root == null){
             Node newNode = new Node(value);
             root = newNode;
             return root;
         }
         
         if(value < root.value ){
             root.leftNode = insertNode(root.leftNode, value);
         }
         
         if(value>= root.value){
             root.rightNode = insertNode(root.rightNode, value);
         }
         
         return root;
     }
     
     private void printTree(Node root){
         if(root == null){
             System.out.println("No item!!");
             return;
         }
         
         if(root.leftNode!=null){
              printTree(root.leftNode);
         }
         
         System.out.println(root.value);
         
         if(root.rightNode!=null){
              printTree(root.rightNode);
         }
     }
     
    
}