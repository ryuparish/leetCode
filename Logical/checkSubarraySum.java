class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Unique ghost pointer technique
        // If the value of sum reaches some number n at some point a , this means that a multiple of k
        // has been found AND at the same time, we can just continue because it is as if we set
        // our "startPointer" and began a new subarray. If we see n again at some other point b, this
        // means that the sum between a and b is some multiple of k.
        int sum = 0;
        // We need a hashmap because we may possibly have k right after a subarray that sums to k,
        // in which, the value k by itself does not count as a valid subarray. The purpose of the put is
        // very confusing, for dealing with sum%=k being 0.
        HashMap<Integer, Integer> nIndex = new HashMap<Integer, Integer>(){{put(0,-1);}};
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            sum %= k;
            Integer idx = nIndex.get(sum);
            if(idx != null){
                if(i - idx > 1){return true;}
                // If we reach here, this is because the next element after a subarray sum of k was
                // k itself.
            }
            // We don't reset the value stored because it has to be at MINIMUM > 1. The smaller the better.
            else{nIndex.put(sum, i);}
        }
        return false;
    }
}
