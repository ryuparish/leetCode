// Gist: The way this works is a divide and conquer algorithm that also utilizes iteration.
// The base case would be the very last operator where the subproblems would be the last digit
// and the second to last digit. There is too much to write, so there is a picture in 
// my directory that may help with this. This is a deep divide and conquer problem.
//
// My attempt to explain in a short paragraph:
// For anything larger than 2 digits, the group will produce multiple different ways of
// combining the numbers and the ways are found with recursion while the iteration moves the 
// place that will be split upon.
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> returnVals = new ArrayList<Integer>();
        for(int i = 0; i < expression.length(); ++i){
            char currChar = expression.charAt(i);
            
            // We split if it is an operator that we land on
            if(currChar == '+' || currChar == '-' || currChar == '*'){
                List<Integer> split1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> split2 = diffWaysToCompute(expression.substring(i+1));
                
                // Note: in the case that this is 1 v 1, it will only iterate a total of 1 time.
                // ie. Split between (1) + (2)
                for(Integer combo1 : split1){
                    for(Integer combo2 : split2){
                        int outcome = 0;
                        switch (currChar) {
                            case '+': outcome = combo1 + combo2;
                                break;
                            case '-': outcome = combo1 - combo2;
                                break;
                            case '*': outcome = combo1 * combo2;
                                break;
                        }
                        returnVals.add(outcome);
                    }
                }
            }
        }
        
        // Don't worry about spaces, as they do not appear in this string
        // This will only activate on a single digit string expression
        if(returnVals.size() == 0){
            /// Caution: Using a char in place of a string will return an ASCII value
            /// instead of the desired integer.
            returnVals.add(Integer.valueOf(expression));
        }
        return returnVals;
    }
}
