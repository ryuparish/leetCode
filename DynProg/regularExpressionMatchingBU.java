// Bottom Up approach 
class Solution {
    public static boolean isMatch(String text, String pattern) {
        boolean[][] memo = new boolean[text.length() + 1][pattern.length() + 1];
        // KEY
        // If we are at the end of both strings, then the pattern has been processed and the string
        // is completely matched at the end of the process (the goal)
        memo[text.length()][pattern.length()] = true;

        // We iterated negatively to see if we can get back to the goal from all possible positions
        // and memoizing each position as yay or nay.
        for(int i = text.length(); i >= 0; --i){

            // We start on pattern.length() - 1 to cover the edge case of an empty pattern
            for(int j = pattern.length() - 1; j >= 0; --j){

                // Match serves as being the guardian recursing with text being empty and 
                // for seeing if the chars match at this position
                boolean match = (i < text.length() && 
                        (text.charAt(i) == pattern.charAt(j) || 
                         pattern.charAt(j) == '.'));

                // This is for checking if value iterated on before was a star, if so,
                // we check the success of the iteration of the string that was one after that and "or" it
                // with the success of ignoring the star entirely.
                if(j+1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    // If the one behind is a star, then we can
                    memo[i][j] = memo[i][j+2] || (match && memo[i+1][j]);
                }

                // If no asterisk, then we check the success of a previous iteration at i+1 j+1 to
                // see if we can make to the success state from there. If and only if they matched since there is no
                // asterisk afterwards.
                else{
                    memo[i][j] = (match && memo[i+1][j+1]);
                }
            }
        }
        // We return if it is possible to return to the success state from the very beginning (the
        // question it self)
        return memo[0][0];
    }

    public static void main(String[] args){
        String string1 = "";
        String string2 = "aa";
        boolean answer = isMatch(string1, string2);
        System.out.println(answer);
        return;
    }

}
