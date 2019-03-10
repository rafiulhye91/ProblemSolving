import java.util.*; 

public class Prime{
    
     public static void main(String []args){
        
    //   int[] numbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
    //   43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 
    //   137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};
       
       int[] numbers = {4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 
       28, 30, 32, 33, 34, 35, 36, 38, 39, 40, 42, 44, 45, 46, 48, 49, 50, 51, 52, 54, 
       55, 56, 57, 58, 60, 62, 63, 64, 65, 66, 68, 69, 70, 72, 74, 75, 76, 77, 78, 80, 
       81, 82, 84, 85, 86, 87, 88, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100, 102, 104, 
       105, 106, 108, 110, 111, 112, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 
       124, 125, 126, 128, 129, 130, 132, 133, 134, 135, 136, 138, 140, 141, 142, 143, 
       144, 145, 146, 147, 148, 150};
       
       Prime prime = new Prime();
       
       for(int i =0; i<numbers.length;i++){
           if(prime.isAPrime(numbers[i])){
               System.out.println(numbers[i]+" is a prime");
           }
           else{
               System.out.println(numbers[i]+" is NOT a prime");
           }
       }
       
     }
     
     private boolean isAPrime(int n){
         if(n==2){
             return true;
         }
         if(n<=1 || n%2==0 ){
             return false;
         }
         
         int closestSqrt = (int) Math.sqrt(n);
         
         for(int i=3; i<=closestSqrt; i=i+2){
             if(n%i==0){
                 return false;
             }
         }
         
         return true;
     }
 
}