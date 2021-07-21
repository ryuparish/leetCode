import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        if(nums.length < 4){return listOfLists;}
        int subTarget = 0, frontHead = 0, backHead = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i-1]){continue;}
            for(int j = i+1; j < nums.length; ++j){
                frontHead = j + 1;
                backHead = nums.length -1;
                if(j > i+1 && nums[j] == nums[j-1]){continue;}
                while(frontHead < backHead){
                    subTarget = nums[i] + nums[j] + nums[frontHead] + nums[backHead];
                    if(subTarget == target){
                        List<Integer> newArray = new ArrayList<Integer>();
                        newArray.add(nums[i]);
                        newArray.add(nums[j]);
                        newArray.add(nums[frontHead]);
                        newArray.add(nums[backHead]);
                        listOfLists.add(newArray);
                        frontHead++;
                        backHead--;
                        while(backHead > frontHead && nums[backHead] == nums[backHead+1]){
                            backHead--;
                        }
                        while(backHead > frontHead && nums[frontHead] == nums[frontHead-1]){
                            frontHead++;
                        }
                    }
                    else if(subTarget > target){
                        backHead--;
                    }
                    else{
                        frontHead++;
                    }
                }
            }
        }
        return listOfLists;
    }
    public static void main(String[] args){
        Solution mySolution = new Solution();
        //int target = 0;
        int target = 8;
        //int[] nums = {-2, -1, -1, 1, 1, 2, 2};
        int[] nums = {2,2,2,2,2};
        List<List<Integer>> myAnswers = mySolution.fourSum(nums, target);
        System.out.println(myAnswers);
    }
}
