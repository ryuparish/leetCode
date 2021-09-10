class Solution {
    // This algorithm is based on this equation: x - k = y where y is the complement of y
    // x and y will be cumulative sums. Visually it would be represented as the values between sum found
    // at x and the sum at y (excluding the number at y). It is required for that the y is behind the x
    // because it represents the sum of values between x and y excluding y.
    // ie.
    //     k = 7
    //     Array[3,4,7,2,-3,1,4,2]   Complements 
    //  Cum Sums 3                   -4                                                       
    //             7                 0 
    //               14              7  < a
    //                 16            9
    //                   13          6
    //                      14       7  < b
    //                        18     11
    //                          20   13
    // In the case of something like a and b, if we found a 21 that complemented k to be 14, then there
    // would be 2 ways to get from 14 to 21 (summing to 7) so that is why we recorded key 14 as 2.
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>(){{put(0,1);}};
        int sum = 0, count = 0;
        for(int i = 0; i < nums.length; ++i){
            sum += nums[i];
            if(comp.containsKey(sum - k)){
                count += comp.get(sum-k);
            }
            comp.put(sum, comp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
