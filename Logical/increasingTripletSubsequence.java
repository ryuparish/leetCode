// TC: O(n), SC: O(1)
// This one seems almost too simple. We can greedily do a linear search.
// In the case that a new min is found, we can still know that there is a 
// min and mid that are still valid and looking for a third for their triplet.
// More explanation here (especially for the new min found idea): https://leetcode.com/problems/increasing-triplet-subsequence/editorial/?envType=study-plan-v2&envId=leetcode-75
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; ++i){
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= mid) {
                mid = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
