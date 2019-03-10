import java.util.*; 

public class Palindorme{
    
     public static void main(String []args){
         Palindorme palindorme = new Palindorme();
        String[] inputs = {"crew work","work crew", "dry yard", "easy", "Funny enough", 
        "Let Bob tell", "new moon", "selfless", "Sorry, Ross", "Talk, Scott", "to boot", 
        "top spot", "Y'all lie", "You're caught. Talk, Roy", "You're damn mad, Roy", 
        "Never odd or even", "We     panic in a pew", "Won't lovers revolt now", 
        "Don't nod", "Sir, I demand, I am a maid named Iris"};
        
        for(int i=0; i<inputs.length;i++){
            if(palindorme.isPalindrome(inputs[i])){
                System.out.println(inputs[i]+" - is a palindrome!");
            }
            else{
                System.out.println(inputs[i]+" - is NOT a palindrome!");
            }
        }
    
     }
     
     private boolean isPalindrome(String str){
         if(str==null || str.length()<=0){
             return false;
         }
         str= str.toLowerCase();
         str= str.replaceAll("\\s+","").replaceAll("\\p{Punct}", "");
         StringBuffer strBuf = new StringBuffer(str);
         int start=0;
         int end = strBuf.length()-1;
         
         while(start<end){
             if(strBuf.charAt(start)!=strBuf.charAt(end)){
                 return false;
             }
             start++;
             end--;
         }
         return true;
     }
 
}