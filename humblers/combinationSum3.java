import java.util.*;
class Solution {
    // Simulate adding value before recursion by adding then removing add after recursion
    //     - In the for loop, we do this by just calling with i instead or position, since we will simulate adding.
    // Simulate adding value before appending to answer by adding then removing after appending (This will pass the reference into the answer and mess things up. We need to give a copy instead). 
    List<List<Integer>> answers = new ArrayList<List<Integer>>();
    public void addSolutions(int[] candidates, ArrayList<Integer>currPath, int target, int sum, int position){
        int currValue = candidates[position];
        // If the sum is too large
        if(sum + currValue > target){
            return;
        }
        // If the sum is exactly right
        else if(sum + currValue == target){
            currPath.add(currValue);
            ArrayList<Integer> newAnswer = new ArrayList<Integer>();
            newAnswer.addAll(currPath);
            answers.add(newAnswer);
            currPath.remove(currPath.size() -1);
            return;
        }
        // If the sum is not reached equal or greater than
        // Recursing and adding currValue itself
        currPath.add(currValue);
        addSolutions(candidates, currPath, target, sum+currValue, position);
        currPath.remove(currPath.size() -1);
        // Recursing and adding the next value if it is possible
        for(int i = position+1; (i < candidates.length) && (sum + candidates[i] <= target || candidates[i]*2 < target); ++i){
            System.out.println("currPath: " + currPath + " sum: " + sum + " candidates[i]: " + candidates[i]);
            addSolutions(candidates, currPath, target, sum, i);
        }
    }

    public void findCombos(int[] candidates, ArrayList<Integer> currPath, int target){
        // Horizontal movement
        for(int i = 0; i < candidates.length && candidates[i] <= target; ++i){
            int currValue = candidates[i];
            if(currValue < target){
                addSolutions(candidates, currPath, target, 0, i);
            }
            else if(currValue == target){
                addSolutions(candidates, currPath, target, 0, i);
            }
        }
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        ArrayList<Integer> currPath = new ArrayList<Integer>();
        findCombos(candidates, currPath, target);
        return answers;
    }

    public static void main(String[] args){
        Solution mySolution = new Solution();
        int[] myList = {2, 3, 5};
        //int[] myList = {2, 3, 6, 7};
        //int target = 7;
        int target = 8;
        mySolution.combinationSum(myList, target);
        System.out.println(mySolution.answers);
        return;
    }
}
