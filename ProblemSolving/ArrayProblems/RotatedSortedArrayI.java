/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */

class RotatedSortedArrayI {
    public int search(int[] nums, int target) {
        int size = nums.length;
        if(size<1){
            return -1;
        }
        int i;
        for(i=0; i<size-1; i++){
            if(nums[i]>nums[i+1]){
                break;
            }
        }
        int firstHalf = binarySearch(nums, 0, i, target);
        int secondHalf = binarySearch(nums, i+1, size-1, target);

        if(firstHalf!=-1){
            return firstHalf;
        }
        if(secondHalf!=-1){
            return secondHalf;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int left, int right, int target){
        if(left>right){
            return -1;
        }

        int mid = left+(right-left)/2;
        if(target == nums[mid]){
            return mid;
        }

        if(target < nums[mid]){
            return binarySearch(nums, left, mid-1, target);
        }

        if(target > nums[mid]){
            return binarySearch(nums, mid+1, right, target);
        }
        return -1;
    }
}