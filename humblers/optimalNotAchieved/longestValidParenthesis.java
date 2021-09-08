// In an ocean of wrong answers, I have found myself in the deepest depths of being incorrect. This one was yet another edge case bullet storm.
// Edge case I quit on:")(()(()(((())(((((()()))((((()()(()()())())())()))()()()())(())()()(((()))))()((()))(((())()((()()())((())))(())))())((()())()()((()((())))))((()(((((()((()))(()()(())))((()))()))())" 
import java.util.*;
class Solution {
    static int[] memo;

    public static int recurseString(int recursingFrom, int[] memo, Stack<Character> currStack, String s, int position, int streak){
        // Base Case if we pass the maximum length for any case
        if(position == s.length()){
            if(currStack.empty()){
                return streak;
            }
            return 0;
        }
        if(s.charAt(position) == ')' && memo[position] == -1){memo[position] = 0;}
        
        // If the current stack can keep going
        // Getting the max of either stopping here or continuing the recursion (if continuing gives valid result)
        //System.out.println("Current streak: " + streak + " Current stack: " + currStack.toString() + " Current position: " + position + " RecursingFrom: " + recursingFrom);
        if(!currStack.empty() && currStack.peek() == '(' && s.charAt(position) == ')'){
            currStack.pop();
            // We only want to include the match in the return value if the current state is actually valid
            int maxIfValid = 0;
            if(currStack.empty()){
                streak += 2;
                maxIfValid = recurseString(recursingFrom, memo, currStack, s, position+1, streak);
            }
            else{maxIfValid = recurseString(recursingFrom, memo, currStack, s, position+1, streak+2);}
            //System.out.println("First condtional maxIfValid returned: " + maxIfValid + " current stack: " + currStack.toString());
            streak = maxIfValid > streak ? maxIfValid : streak;
        }

        // Getting the max of either stacking more open parentheses with or without other open parenthesis in stack
        else if((currStack.empty() || currStack.peek() == '(') && s.charAt(position) == '('){
            boolean wasEmpty = currStack.empty() ? true : false;
            currStack.push('(');
            int maxIfValid = recurseString(recursingFrom, memo, currStack, s, position+1, streak);
            if(wasEmpty){memo[position] = maxIfValid;}
            if(!wasEmpty && maxIfValid == 0){streak = 0;}
            streak = maxIfValid > streak ? maxIfValid : streak;
            //System.out.println("Second condtional maxIfValid returned: " + maxIfValid + " current stack: " + currStack.toString());
            // This messes up the case where we are in a chance recurse and we need to return 0(last conditional will return the inflated streak instead)
            if(!currStack.empty()){currStack.pop();}
            //System.out.println("Stack after pop (or it was already empty: " + currStack.toString());
        }
        
        // Recurse new stack for memoization if possible before we return the old stack result (for skipping recursions)
        if(s.charAt(position) == '(' && memo[position] == -1){
            Stack<Character> newStack = new Stack<Character>();
            newStack.push('(');
            memo[position] = recurseString(recursingFrom, memo, newStack, s, position+1, 0);
            //System.out.println(position + " set to: " + memo[position]);
        }

        // Returning streak if the stack in is invalid state (empty and ')' in position) and did not activate the first two conditionals since the streak kept track of the matches
        // Or if the value recursed and did not find a solution while searching with some extra parentheses from a "chance" recursion call in first conditional and we return 0.
        return currStack.empty() ? streak : 0;
    }
        
    // This will keep track of the current max during the traversal of the string, so the memo is used here
    public static int longestValidParentheses(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        int max = 0, newValue;
        for(int i = 0; i < s.length(); ++i){
            if(memo[i] == 0){
                continue;
            }
            Stack<Character> newStack = new Stack<Character>();
            newValue = recurseString(i, memo, newStack, s, i, 0);
            if(newValue > max){
                max = newValue;
            }
        }
        return max;
    }

    //public static void main(String[] args){
    //    //String myString = "()(()(((";
    //    //String myString = "((()()(()((()";
    //    //String myString = "((((()()))((";
    //    //String myString = "((((()()(())";
    //    int answer = longestValidParentheses(myString);
    //    System.out.println(answer);
    //    return;
    //}
}
