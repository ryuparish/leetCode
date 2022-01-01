// Gist: You first sort the list, then you take the difference between the largest and smallest value.
// This "diff" will be added to all other indices. The first iteration will make the first and
// the last elements equal. The second iteration will turn the first , last, and the second to last into equal numbers and
// so on. This is apparently the minimum, which I am not sure how to prove.
class Solution {
    public int minMoves(int[] nums) {
        // O(nlogn)
        //Arrays.sort(nums);
        
        // O(n), finding the smallest value in the array
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; ++i){
            min = Math.min(min, nums[i]);
        }
        
        // Counting up the "diff" from each element in the array and adding it to get the
        // minimum number of moves.
        int count = 0;
        for(int i = nums.length-1; i >= 0; --i){
            count += nums[i] - min;
        }
        return count;
    }
}
