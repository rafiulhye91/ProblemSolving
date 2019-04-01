/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"

*/

class Solution {
    public String reverseVowels(String s) {
        if(s==null){
            return s;
        }
        int size = s.length();
        if(size<=1){
            return s;
        }
        
        int i = 0;
        int j = size-1;
        StringBuilder  str = new StringBuilder(s);
        while(i<=j){
            while(i<size && !isAVowel(str.charAt(i))){
                i++;
            }
            while(j>=0 && !isAVowel(str.charAt(j))){
                j--;
            }
            if(i>j){
                break;
            }
            char tempI = str.charAt(i);
            char tempJ = str.charAt(j);
            str.setCharAt(i, tempJ);
            str.setCharAt(j, tempI);
            i++;
            j--;
        }
        
        return str.toString();
    }
    
    private boolean isAVowel(char c){
        if(c=='A'||c=='E'|| c=='I'||c=='O' ||c=='U'){
            return true;
        }
        if(c=='a'||c=='e'|| c=='i'||c=='o' ||c=='u'){
            return true;
        }
        return false;
    }
}