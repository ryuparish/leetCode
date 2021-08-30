class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Loop calls to a backtracking function up to nums.length times
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        // Making an ArrayList out of the nums integer array
        // Looping the backtracking calls
        for(int i = 0; i <= nums.length; ++i){
            backTrack(answers, new ArrayList<Integer>(), nums, i, 0);
        }
        return answers;
    }
    // n is the size of the answer to be made and then start is the position it will start from
    public void backTrack(List<List<Integer>> answers, List<Integer> currList, int[] nums, int listSize, int start){
        if(listSize == 0){
            ArrayList<Integer> newList = new ArrayList<Integer>(currList);
            answers.add(newList);
            return;
        }
        for(int i = start; i <= nums.length-listSize; ++i){
            currList.add(nums[i]);
            backTrack(answers, currList, nums, listSize-1, i+1);
            currList.remove(currList.size()-1);
        }
    }
}
