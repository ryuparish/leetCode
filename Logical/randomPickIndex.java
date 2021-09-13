 class Solution {
    // For each number, there will be a list of indexes that contain that number.
    HashMap<Integer, List<Integer>> dupeMap = new HashMap<Integer, List<Integer>>();

    public Solution(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            if(!dupeMap.containsKey(nums[i])){
                dupeMap.put(nums[i], new ArrayList<Integer>());
            }
            dupeMap.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int idx = new Random().nextInt(dupeMap.get(target).size());
        return dupeMap.get(target).get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
