class Solution {
    // Flow of this algorithm
        // 1. Differentiate which monotonic side the mid value lays upon
        //
        // 2. Check the mid value and the relevant end to make sure you don't skip the target.
        //
        // We need to do the conditional in this way in case this happens:
        // ie. [7,8,9,10,1,2,3,4,5,6]
        //                 ^
        //                mid
        // target = 10 (will be skipped)
        // ie. [4,5,6,7,8,9,10,11,1,2,3]
        //                ^
        //               mid
        // target = 2 (will be skipped)
        // If we do regular binary search, we will end up skipping over the target.
        // So we need to check the relevant ends to make sure we don't skip over it.
        // This is made simple because we can only surely know which side the target is in on
        // a single side for either situation.
        //
        // 3. Set end accordingly.
        //
        // 4. Make sure to skip over duplicates
    public boolean search(int[] nums, int target) {
        
        if(nums == null || nums.length == 0){return false;}
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            while(lo < hi && nums[lo] == nums[lo+1])
                lo++;
            while(lo < hi && nums[hi] == nums[hi-1])
                hi--;
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target){return true;}
            // If the mid value is in the left side
            if(nums[mid] >= nums[lo]){
                // If target definitely is on left side
                if(target >= nums[lo] && target < nums[mid]){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            // If the mid value is in the right side
            else{
                // If target is definitely on the 
                if(target <= nums[hi] && target > nums[mid]){
                    lo = mid+1;
                }
                else{
                    hi = mid-1;
                }
            }
        }
        return false;
    }
}
