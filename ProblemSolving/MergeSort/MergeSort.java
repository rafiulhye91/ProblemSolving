import java.util.*; 

public class MergeSort{
    
     public static void main(String []args){
        int[] A = {100,200,300,400,5,4,9,500,700,4,6,7,30,50,71};
        
        int size = A.length;
        MergeSort mergeSort = new MergeSort();
        mergeSort.printArray(A);
        mergeSort.mergeSort(A, 0, size-1);
        mergeSort.printArray(A);
       
     }
     
     private int[] mergeSort(int[] A, int left, int right ){
         if(left>=right){
             return A;
         }
         
         int center = left+((right-left)/2);
         mergeSort(A, left, center);
         mergeSort(A, center+1, right);
         merge(A, left, center, right);
         
         return A;
         
     }
     
     private void merge(int[] A, int left, int center, int right){
         int n1= center-left+1;
         int n2 = right-center;
         
         int tempLeft[] = new int[n1];
         int tempRight[] = new int[n2];
         
         for(int i=0; i<n1;i++){
             tempLeft[i] = A[left+i];
         }
         
         for(int j=0; j<n2;j++){
             tempRight[j] = A[center+1+j];
         }
         
         int i=0;
         int j=0;
         int k=0;
         
         while(i<n1 && j<n2){
            if(tempLeft[i]<=tempRight[j]){
                 A[left+k] = tempLeft[i];
                 i++;
             }
             else {
                 A[left+k] = tempRight[j];
                 j++;
             }
             k++;
         }
         
         while(i<n1){
             A[left+k] = tempLeft[i];
             i++;
             k++;
         }
         
         while(j<n2){
             A[left+k] = tempRight[j];
             j++;
             k++;
         }
         
     }
     
     private void printArray(int[]A){
         int size = A.length;
         System.out.print("Array: ");
         
         for(int i=0; i< size; i++){
             System.out.print(" "+A[i]);
         }
         
         System.out.print("\n");
     }
        
}