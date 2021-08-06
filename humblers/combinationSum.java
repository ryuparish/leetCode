import java.util.*;
class Solution {
    List<List<Integer>> answers = new ArrayList<List<Integer>>();
    public boolean findCombos(int[] currArray, ArrayList<Integer> currPath, int currSum, int currPosition){

        int currValue = currArray[currPosition];
        System.out.println("currValue at the very beginning of the list: " + currValue);

        // Return null if currnum is too large
        if((currSum - currValue) < 0){
            System.out.println("Value too large: " + currValue + " with currPath: " + currPath + " and currSum: " + currSum);
            return false;
        }

        // Return the arrayList if number is just right
        else if(currSum - currValue == 0){
            ArrayList<Integer> answer = (ArrayList<Integer>)currPath.clone();
            answer.add(currValue);
            System.out.println("Found answer: " + answer);
            answers.add(answer);
            return true;
        }

        ArrayList<Integer> cloneList = new ArrayList<Integer>();
        cloneList = (ArrayList<Integer>)currPath.clone();
        cloneList.add(currValue);
        // If the currSum + currValue is under the target value (we know it will fit)
        findCombos(currArray, cloneList, currSum - currValue, currPosition);

        // We iterate forward with another number to see if there
        // is a different combonation possible with a different number at the current position.
        
        System.out.println("Outside for loop");
        // If the number is too large, the first conditional will activate and quit the loop
        for(int i = currPosition + 1; i < currArray.length; ++i){
            // Removing the last value to the next value in the array
            System.out.println("for loop beginning currPath: " + currPath);
            currValue = currArray[i];
            // Break if the value is too large
            if((currSum - currValue) < 0){
                System.out.println("currValue in loop: " + currValue + " is too large for currPath: " + currPath);
                break;
            }
            // Break if the value at this position does not have any valid combinations
            if(!findCombos(currArray, currPath, currSum, i)){
                break;
            }
            System.out.println("After recursion:" + currPath);
        }
        return true;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<Integer> currPath = new ArrayList<Integer>();
        findCombos(candidates, currPath, target, 0);
        return answers;
    }
    public static void main(String[] args){
        Solution mySolution = new Solution();
        int[] myArray = {2, 3, 6, 7};
        mySolution.combinationSum(myArray, 7);
        System.out.println("Answers: " + mySolution.answers);
        return;
    }
}
