// Gist: 
// TC: O(n), SC: O(n)
//class Solution {
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> numCount = new HashMap<>();
//        for(int i = 0; i < nums.length; ++i){
//            numCount.computeIfAbsent(nums[i], k -> 0);
//            if(numCount.get(nums[i]) == 1){
//                numCount.remove(nums[i]);
//            }
//            else{numCount.put(nums[i], 1);}
//        }
//        return numCount.keySet().iterator().next();
//    }
//}
// TC: O(n), SC: O(1)
// Bit Manip "With every action there is an equal and opposite reaction"
class Solution {
    public int singleNumber(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length; ++i){
            answer ^= nums[i];
        }
        return answer;
    }
}
