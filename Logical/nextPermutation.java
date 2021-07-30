// O(n^2)
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 1){return;}
        // Starting at the very right value and looking right to find a smaller value. The first match of this conditional will be the answer
        // because if there was a second smaller value past the found match, the match itself would have found that smaller value.
        int smallestLargerValue = 1000, smallestValueIndex = -1;
        boolean valueFound = false;
        for(int i = nums.length - 1; i >= 0; --i){
            for(int j = i; j < nums.length; ++j){
                if(nums[i] < nums[j] && nums[j] < smallestLargerValue){
                    //System.out.println("num[i]: " + nums[i] + " nums[j]: " + nums[j] + " matched");
                    smallestLargerValue = nums[j];
                    smallestValueIndex = j;
                    valueFound = true;
                }
            }
            if(valueFound){
                int swapper = nums[i];
                nums[i] = nums[smallestValueIndex];
                nums[smallestValueIndex] = swapper;
                // We now need to sort the left side of the list to make sure we have the absolute smallest permutation the swapped version of 
                // the number. (that would be the only possible "next" value)
                Arrays.sort(nums, i+1, nums.length);
                break;
            }
        }
        if(!valueFound){
            Arrays.sort(nums);
        }
        return;
    }
}
