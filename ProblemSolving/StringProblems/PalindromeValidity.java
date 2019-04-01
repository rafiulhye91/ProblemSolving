/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

class PalindromeValidity {
    public boolean isPalindrome(String s) {
        if(s==null){
            return false;
        }
        s=(s.replaceAll("\\p{Punct}", "")).replaceAll(" ", "").toLowerCase();
        int size = s.length();
        if(size<=1){
            return true;
        }

        int i=0;
        int j=size-1;

        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}