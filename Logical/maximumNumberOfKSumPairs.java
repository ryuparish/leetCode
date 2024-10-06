// TC: O(n), SC: O(n)
// This is just like two sum with the hashmap and saving complements.
class Solution {
    public int maxOperations(int[] nums, int k) {
        int operations = 0;
        Map<Integer, Integer> opMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i){
            int complement =  k - nums[i];
w
            // Update whether we do or dont find the complement using getOrDefault
            if (opMap.getOrDefault(complement, 0) > 0){
                int numOfComplements = opMap.get(complement);
                opMap.put(complement, numOfComplements-1);
                operations++;
            // Update whether we do or dont find the nums[i] using getOrDefault
            } else {
                opMap.put(nums[i], opMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        return operations;
    }

