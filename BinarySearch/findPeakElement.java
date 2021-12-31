// Gist: To find a certain peak, we can use the Binary Search algorithm. The method is to follow inclines to find 
// find a certain peak in logarithmic time. If the right part is lower than, then we know there is for certain a peak
// to the left. And if there is larger next index, then we know there is a peak to the right.
// TC: O(logn) SC: O(1);
class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    private int binarySearch(int[] nums, int l, int r){
        while(l < r){ // This will catch cases where the index to the right of index is out of bounds
            int index = (r + l) /2;
            if(nums[index] > nums[index +1]){
                r = index;
            }
            else{
                l = index +1;
            }
        }
        return l;
    }
}
