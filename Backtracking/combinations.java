// Classic Backtracking/Simulation set up
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        findCombos(answers, currList, 1, n, k);
        return answers;
    }
    public void findCombos(List<List<Integer>> answers, List<Integer> currList, int start, int n, int k){
        // Using the digit placement for the base case rather than the
        // size of currList because k is always changing and comparing currList with k would be faulty
        if(k == 0){
            ArrayList<Integer> newList = new ArrayList<Integer>(currList);
            answers.add(newList);
            return;
        }
        // Simulating the adding the current number to the list
        // When we increment this i value, it could possibly be the first value of the currList making a new beginning
        // but it could also be the start of another half as in:
        //      currList: [1] k = 3
        //      1 2 3 4 5 
        //      ^   ^
        //     [1]  i(start of the the other half of the 3 length array)
        for(int i = start; i <= (n-k)+1; ++i){
            currList.add(i);
            findCombos(answers, currList, i+1, n, k-1);
            currList.remove(currList.size()-1);
        }
        // The value n-k+1 is extremely helpful when it comes to limiting recursion and also for making sure all values are seen
    }
}
