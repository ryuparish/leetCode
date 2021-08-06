import java.util.*;
class Solution {
    // Simulate adding value before recursion by adding then removing add after recursion
    //     - In the for loop, we do this by just calling with i instead or position, since we will simulate adding.
    // Simulate adding value before appending to answer by adding then removing after appending (This will pass the reference into the answer and mess things up. We need to give a copy instead). 
    List<List<Integer>> answers = new ArrayList<List<Integer>>();
    public void findCombos(int[] candidates, ArrayList<Integer> currPath, int target, int sum, int position){
        // Vertical movement
        // Base Case of either going over or hitting the target
        int currValue = candidates[position];
        if(sum + currValue > target){
            return;
        }
        else if(sum + currValue == target){
            currPath.add(currValue);
            ArrayList<Integer> newAnswer = new ArrayList<Integer>();
            newAnswer.addAll(currPath);
            answers.add(newAnswer);
            currPath.remove(currPath.size() -1);
            return;
        }
        
        // Calling for the same value because it sum didn't go equal to or over target
        currPath.add(currValue);
        findCombos(candidates, currPath, target, sum+currValue, position);
        currPath.remove(currPath.size() -1);

        // Horizontal movement
        for(int i = position+1; i < candidates.length && candidates[i]*2 < target; ++i){
            currValue = candidates[i];
            if(sum + currValue < target){
                findCombos(candidates, currPath, target, sum, i);
            }
            else if(sum + currValue == target){
                findCombos(candidates, currPath, target, sum, i);
                break;
            }
            else{break;}
        }
        return;
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        ArrayList<Integer> currPath = new ArrayList<Integer>();
        findCombos(candidates, currPath, target, sum, 0);
        return answers;
    }

    public static void main(String[] args){
        Solution mySolution = new Solution();
        int[] myList = {2, 3, 6, 7};
        int target = 7;
        mySolution.combinationSum(myList, target);
        System.out.println(mySolution.answers);
        return;
    }
}
