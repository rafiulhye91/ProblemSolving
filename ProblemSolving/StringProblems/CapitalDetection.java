/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
 */

class CapitalDetection {
    public boolean detectCapitalUse(String word) {
        int size = word.length();
        if(size<1){
            return false;
        }
        if(isAllCapital(word,size)){
            return true;
        }
        if(isAllSmall(word,size)){
            return true;
        }
        if(isPreccedingCapital(word, size)){
            return true;
        }
        return false;
    }

    private boolean isAllCapital(String word, int size){
        for(int i =0; i<size; i++){
            char c = word.charAt(i);
            if(c < 'A' || c>'Z'){
                return false;
            }
        }
        return true;
    }

    private boolean isAllSmall(String word, int size){
        for(int i =0; i<size; i++){
            if(word.charAt(i)<'a' || word.charAt(i)>'z'){
                return false;
            }
        }
        return true;
    }

    private boolean isPreccedingCapital(String word, int size){
        if(word.charAt(0)<'A' || word.charAt(0)>'Z'){
            return false;
        }
        String suffix = word.substring(1);
        return isAllSmall(suffix, suffix.length());
    }
}