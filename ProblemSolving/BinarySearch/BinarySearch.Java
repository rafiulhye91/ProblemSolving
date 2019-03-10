import java.util.*;

public class BinarySearch{

    public static void main(String []args){
        int [] input = {100,200,300,400,500,600,700,800,900};
        int value = 700;

        BinarySearch binarySearch = new BinarySearch();

        int startIndex=0;
        int endIndex = input.length-1;
        int index= binarySearch.search(value, startIndex, endIndex, input);

        System.out.println("found in index: "+index);
    }

    private int search(int value, int start, int end, int []input){

        int mid = start+(end-start)/2;

        if(value == input[mid]){
            return mid;
        }
        if(value < input[mid]){
            return search(value, start, mid, input);
        }
        if(value > input[mid]){
            return search(value, mid+1, end, input);
        }

        return -1;
    }

}