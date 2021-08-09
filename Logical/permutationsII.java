class Solution {
    List<List<Integer>> answers = new ArrayList<List<Integer>>();
    public void permuteNums(int[] nums, int position){
        // The end of the permutation is reached
        if(position == nums.length){
            ArrayList<Integer> newAnswer = new ArrayList<Integer>();
            for(int integer : nums){
                newAnswer.add(integer);
            }
            answers.add(newAnswer);
            return; 
        }
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        // Iteratively Recursing
        for(int i = position; i < nums.length; ++i){
            // Simulate swapping two places in the nums if they are different
            // Permutes iff the number nums[i] has never been seen before from the current position
            if(counter.containsKey(nums[i]) == false){
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                permuteNums(nums, position+1);
                // End simulation
                nums[position] = nums[i];
                nums[i] = temp;
                counter.put(nums[i], 1);
            }
        }
        return;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteNums(nums, 0);
        return answers;
    }
}
