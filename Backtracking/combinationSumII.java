// (MISTAKE 1) Java Effect 1: In Java, only primitives(int, char, boolean...) are passed by value. For more structured objects (such as List, String, int[]...) these are passed as a copy that DOES have copies of 
// the values in the object, but using a method (such as .get(), [] operator, .set(), .add(), .remove()...) will change the original object.

// (MISTAKE 2) Programming BLUNDER (C++, Python, Java): When adding a non-primitive value to a list, say a list or an object, the reference to the object will
// be added too. You must copy the object THEN add it, or else if you change the list/object later, the object in the 2d list will
// also CHANGE. Conserve memory by only using one reference, but ALSO REMEMBER TO COPY OBJECTS INTO OBJECTS RATHER THAN JUST ADD/APPEND

class Solution {

    public void findSolutions(int[] candidates, List<List<Integer>> answers, ArrayList<Integer> currPath, int target, int position){
        // Base Case if the current sum is equal to the target
        if(target == 0){
            answers.add(new ArrayList<Integer>(currPath)); // MISTAKE 2 HAPPENED HERE!
            return;
        }
        // Base Case if the current sum is over the target value
        else if(target < 0){
            return;
        }
        for(int i = position; i < candidates.length; ++i){
            // i > start for avoiding segfault on first value and then checking for the same value as before
            if(i > start && nums[i] == nums[i-1]){continue;}
            // Simulate choosing the number and adding it to the current Path
            currPath.add(candidates[i]);
            // This does nothing until the base case where the 
            // path is either added or the calls return.
            // The side effect is that currPath will have all the
            // values it was recursed with, but then they are removed
            // by the line right below each call
            findSolutions(candidates, answers, currPath, target - candidates[i], i+1);
            currPath.remove(currPath.size() - 1);
        }
    }
        
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        findSolutions(candidates, answers, new ArrayList<Integer>(), target, 0);
        return answers;
    }

}
