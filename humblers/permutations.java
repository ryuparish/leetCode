// You may wonder about how the front-only approach works, but remember that the values behind will also have their own permutations in which all values ahead will be swapped.
class Solution {
    List<List<Integer>> answers = new ArrayList<List<Integer>>();
    public void permuteNums(int[] nums, int position){
        if(position == nums.length){
            ArrayList<Integer> newAnswer = new ArrayList<Integer>(nums.length);
            for(int integer: nums){
                newAnswer.add(integer);
            }
            answers.add(newAnswer);
            return;
        }
        // Simulate swapping the current position with every other position ahead of it and recursing.
        for(int i = position; i < nums.length; ++i){
            int temp = nums[i];
            nums[i] = nums[position];
            nums[position] = temp;
            permuteNums(nums, position+1);
            // Switch back for next simulation
            nums[position] = nums[i];
            nums[i] = temp;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permuteNums(nums, 0);
        return answers;
    }
}
