/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
 */

class UniqueLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int size = s.length();
        if(size == 1){
            return 1;
        }
        int max=0;
        for(int j=0;j<size;j++){
            String Sub= s.substring(j, size);
            int count=0;
            String longestSub= "";
            for(int i=0; i<Sub.length();i++){
                if(longestSub.contains(String.valueOf(Sub.charAt(i)))){
                    break;
                }
                longestSub+=Sub.charAt(i);
                count = longestSub.length();
                if(max<count){
                    max=count;
                }
            }
        }
        return max;
    }
}