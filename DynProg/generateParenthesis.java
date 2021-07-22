import java.util.*;
class Solution {
    //static List<String> listOfAnswers = new ArrayList<String>();
    List<String> listOfAnswers = new ArrayList<String>();
    public void dp(String currString, int n, int balance){
        // Base Case if we reach the end 
        if(currString.length() == (2*n)){
            listOfAnswers.add(currString);
            return;
        }
        
        // Adding a closing bracket, but checking for at least one open bracket first
        if(balance -1 >= 0){
            dp(currString + ")", n, balance -1);
        }

        // Adding an opening bracket, as long as current number of open brackets is less than the remaining spaces(which would contain closing brackets)
        // If I were to add another open bracket while the remaining spaces was equal to or less than the current offset of open brackets, then it would be impossible to have a valid string because
        // there would be too many open brackets and not enough closing brackets.
        if(balance < (2*n) - currString.length()){
            dp(currString + "(", n, balance +1);
        }
        return;
    }
            
    public List<String> generateParenthesis(int n) {
        dp("", n, 0);
        return listOfAnswers;
    }

    //public static void main(String[] args){
    //    Solution mySolution =  new Solution();
    //    int n = 2;
    //    mySolution.generateParenthesis(n);
    //    System.out.println(listOfAnswers);
    //    return;
    //}
}
