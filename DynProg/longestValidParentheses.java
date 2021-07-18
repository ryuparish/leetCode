import java.lang.Math;
class Solution {
    public int longestValidParentheses(String s) {
        // Every time leftCount == rightCount, we can use 2 * left or 2 * right as the longest substring
        // Every time we encounter an invalid start, we set both left and right to 0 because the previous substring cannot continue and only a new string can be found that is longer
        int max = 0, leftCount = 0, rightCount = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){leftCount++;}
            else{rightCount++;}
            if(rightCount > leftCount){rightCount = leftCount = 0;}
            else if(leftCount == rightCount){max = Math.max(max, 2 * rightCount);}
        }
        leftCount = 0;
        rightCount = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            if(s.charAt(i) == ')'){rightCount++;}
            else{leftCount++;}
            if(leftCount > rightCount){rightCount = leftCount = 0;}
            else if(leftCount == rightCount){max = Math.max(max, 2 * leftCount);}
        }
        return max;
    }
}

