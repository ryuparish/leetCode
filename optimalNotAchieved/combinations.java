// Classic Backtracking/Simulation set up
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        findCombos(answers, currList, 1, n, k);
        return answers;
    }
    public void findCombos(List<List<Integer>> answers, List<Integer> currList, int start, int n, int k){
        // Using the digit placement for the base case
        if(k == 0){
            ArrayList<Integer> newList = new ArrayList<Integer>(currList);
            answers.add(newList);
            return;
        }
        // Simulating the adding the current number to the list
        for(int i = start; i <= (n-k)+1; ++i){
            currList.add(i);
            findCombos(answers, currList, i+1, n, k-1);
            currList.remove(currList.size()-1);
        }
    }
}
