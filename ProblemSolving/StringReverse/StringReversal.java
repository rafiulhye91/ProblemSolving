import java.util.*; 

public class StringReversal{
    
     public static void main(String []args){
        StringReversal stringReversal = new StringReversal();
        
        String input = "Hello World!";
        
        System.out.println(stringReversal.reverseAString1(input));
        System.out.println(stringReversal.reverseAString2(input));
       
     }
     
     private String reverseAString1(String input){
         
         if(input == null || input.length()<=1){
             return input;
         }
         
         StringBuffer temp = new StringBuffer(input);
         
         int size = temp.length();
         StringBuffer output = new StringBuffer();
         
         for(int i=size-1; i>=0; i--){
             output.append(temp.charAt(i));
         }
         return output.toString();
     }
     
     private String reverseAString2(String input){
         if(input == null || input.length()<=1){
             return input;
         }
         
         return reverseAString2(input.substring(1))+input.charAt(0);
     }
 
}