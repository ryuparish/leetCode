// TC: O(n^2) , SC: O(n^2)
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int totalCount = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; ++i){
            int one = nums1[i];
            for(int j = 0; j < nums2.length; ++j){
                int two = nums2[j];
                hm.put(one + two, hm.getOrDefault(one+two,0)+1);
            }
        }
        for(int i = 0; i < nums3.length; ++i){
            int three = nums3[i];
            for(int j = 0; j < nums4.length; ++j){
                int four = nums4[j];
                totalCount += hm.getOrDefault(-(three+four), 0);
            }
        }
        return totalCount;
    }
}
