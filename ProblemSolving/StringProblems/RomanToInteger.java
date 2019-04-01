
/*
Example 1:

Input: "III"
Output: 3

Example 2:

Input: "IV"
Output: 4

Example 3:

Input: "IX"
Output: 9

Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

class RomanToInt {
    public int romanToInt(String s) {
        if(s==null){
            return 0;
        }

        int size = s.length();
        int result = 0;
        int prev =0;
        for(int i=0; i< size; i++){
            int digit = convertRomanDigitToNumeric(Character.toString(s.charAt(i)));

            if(prev!=0 && digit>prev){
                result = result-prev;
                result += digit-prev;
            }else{
                result += digit;
            }
            prev = digit;
        }
        return result;
    }

    private int convertRomanDigitToNumeric(String S){
        if(S.equals("I")){
            return 1;
        }
        if(S.equals("V")){
            return 5;
        }
        if(S.equals("X")){
            return 10;
        }
        if(S.equals("L")){
            return 50;
        }
        if(S.equals("C")){
            return 100;
        }
        if(S.equals("D")){
            return 500;
        }
        if(S.equals("M")){
            return 1000;
        }
        return 0;
    }
}