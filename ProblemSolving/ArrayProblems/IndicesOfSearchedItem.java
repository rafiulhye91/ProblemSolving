/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

class IndicesOfSearchedItem {
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        return binarySearch(nums, 0, size-1, target);
    }

    private int[] binarySearch(int[] nums,int left, int right, int target){

        if(left>right){
            return new int[] {-1,-1};
        }
        int mid = left+(right-left)/2;

        if(target == nums[mid]){
            return getPositions(nums, mid);
        }
        if(target < nums[mid]){
            return binarySearch(nums, left, mid-1, target);
        }
        if(target > nums[mid]){
            return binarySearch(nums, mid+1, right, target);
        }
        return new int[] {-1,-1};
    }

    private int[] getPositions(int[] nums, int pos){
        int i = pos;
        int j=pos;
        int size = nums.length;
        while(i>=0 && nums[i]==nums[pos]){
            i--;
        }
        while(j<size && nums[j]==nums[pos]){
            j++;
        }
        return new int[] {i+1,j-1};
    }

}