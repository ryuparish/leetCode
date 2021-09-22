// Gist: Recursive Stack / Backtracking. We use two conditional recursive calls to try both
// adding an additional open bracket if there is enough space to make up for with closed brackets.
// Afterwards or if there is not enough space for closed brackets, then we add closed brackets,
// first checking if there are enough open brackets to do so. We also have an int to keep track
// of the balance of open(+) vs close brackets(-).
class Solution {
    List<String> answer;
    
    private void backTrack(String currString, int balance, int target){
        // Base Case
        if(currString.length() == target){
            // Apparently this works without any problem even though 
            answer.add(new String(currString));
            return;
        }
        
        // Adding open bracket if there is remaining space for closed brackets
        // If there are the same or greater number of open brackets then the space remaining,
        // then we cannot add any more open brackets.
        if(balance < target - currString.length()){
            backTrack(currString + "(", balance+1, target);
        }
        
        // Adding a close bracket if there is there is at least one open bracket to maintain
        // validity
        if(balance > 0){
            backTrack(currString + ")", balance-1, target);
        }
    }
        
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<String>();
        
        // Answers will always have 2*n parenthesis (same length always)
        backTrack("", 0, 2*n);
        return this.answer;
    }
}
