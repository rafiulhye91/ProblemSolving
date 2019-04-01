
/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class FindingLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int size = strs.length;
        if(size<1){
            return "";
        }
        if(size==1){
            return strs[0];
        }

        String longestPrefix = strs[0];

        for(int i=1; i<size; i++){
            String currentStr = strs[i];
            int j=0;
            int currSize = getMin(currentStr, longestPrefix);
            while(j<currSize){
                if(currentStr.charAt(j) != longestPrefix.charAt(j)){
                    break;
                }
                j++;
            }
            longestPrefix = currentStr.substring(0,j);
        }
        return longestPrefix;
    }

    private int getMin(String str1, String str2){
        int size1 = str1.length();
        int size2 = str2.length();
        if(size1<size2){
            return size1;
        }
        return size2;
    }
}