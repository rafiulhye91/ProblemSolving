import java.util.*;

public class StringReversal {

    public static void main(String[] args) {
        StringReversal stringReversal = new StringReversal();

        String input = "Hello World!";

        System.out.println(stringReversal.reverseAString1(input));
        System.out.println(stringReversal.reverseAString2(input));

    }

    private String reverseAString1(String input) {

        if (input == null || input.length() <= 1) {
            return input;
        }

        StringBuffer temp = new StringBuffer(input);

        int size = temp.length();
        StringBuffer output = new StringBuffer();

        for (int i = size - 1; i >= 0; i--) {
            output.append(temp.charAt(i));
        }
        return output.toString();
    }

    private String reverseAString2(String input) {
        int size = input.length();
        if (input == null || size <= 1) {
            return input;
        }

        StringBuffer output = new StringBuffer(input);

        int i = 0;
        int j = size - 1;
        char c;
        while (i <= j) {
            c = output.charAt(i);
            output.setCharAt(i, output.charAt(j));
            output.setCharAt(j, c);
            i++;
            j--;
        }
        return output.toString();
    }

    private String reverseAString3(String input) {
        if (input == null || input.length() <= 1) {
            return input;
        }

        return reverseAString2(input.substring(1)) + input.charAt(0);
    }

}
