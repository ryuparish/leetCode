// TC: O(n), SC: O(1)
// Two pointers with gap check to place zero after the transfer of number from i to j.
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; ++i){
            // Transfer number to j's spot, then set to zero iff
            // a gap has formed
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
            // Checking for gap
            if (i != j-1) {
                nums[i] = 0;
            }
        }
    }
}
