class Solution {
    public int minIncrementForUnique(int[] nums) {
      Arrays.sort(nums);
      int takeCount = 0;
      int increments = 0;
      for (int i = 1; i < nums.length; ++i) {
        // If equal, we "take" one and add to surplus
        if (nums[i-1] == nums[i]) {
          takeCount++;
          increments -= nums[i];
        } else {
          int slots = nums[i] - (nums[i-1] + 1);
          int slotsToUse = Math.min(takeCount, slots);
          // Sum from i to slotsToUse + leveled-platform-needed
          //                         _
          //                   +     _
          //             +     +     _
          //       _     _     _     _ 
          //      ...   ...   ...   ...
          // + -> number of increments needed
          // ... -> number of (nums[i-1]) platforms needed
          // sum of k from 1 to i => n(n-1)/2
          increments += (slotsToUse * nums[i-1]) + ((slotsToUse * (slotsToUse+1))/2);
          takeCount -= slotsToUse;
        }
      }
      
      if (nums.length > 0) {
        increments += (takeCount * nums[nums.length-1]) + ((takeCount * (takeCount+1))/2);
      }
      return increments;
    }
}
