import java.util.*; 

public class QucikSorting{
    
     public static void main(String []args){
        int[] array = new int[500];
        Random random = new Random();
        for(int i=0; i<500; i++){
            int temp = random.nextInt()%500;
            if(temp<0){
                temp=temp*-1;
            }
            array[i] = temp;
        }
        
        int size = array.length;
        QucikSorting qucikSorting = new QucikSorting();
        qucikSorting.printArray(array);
        qucikSorting.quickSort(array, 0, size-1);
        qucikSorting.printArray(array);
     }
     
     private void quickSort(int[] array, int left, int right){
         if(left>=right){
             return;
         }
         int pivot = array[(left+right)/2];
         int index = partition(array, left, right, pivot);
         quickSort(array, left, index-1);
         quickSort(array, index, right);
     }
     
     private int  partition(int[] array, int left, int right, int pivot){
         while(left<=right){
            while(array[left]<pivot){
                left++;
            }
            while(array[right]>pivot){
                right--;
            }
            if(left<=right){
                swap(array, left, right);
                left++;
                right--;
            }
         }
         return left;
     }
     
     private void swap(int[] array, int left, int right){
         int temp = array[left];
         array[left] = array[right];
         array[right] = temp;
         return;
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