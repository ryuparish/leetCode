class longestPalindromicSubstring{
    public static String findPalindromicSubstring(String string){
        // If there is only one letter then there is only solution which is the letter itself forwards and backwards
        if(string.length() == 1){
            return string;
        }
        // Defining the starting indexes in which the palindromic substring begins and starts
        int[] substringIndexes = new int[2];
        for(int i = 0; i < string.length(); ++i){
            // If the possible palindrome is even
            checkPalindrome(string, substringIndexes, i, i);
            // If the possible palindrome is odd and has a solo letter in the middle of the word
            checkPalindrome(string, substringIndexes, i, i+1);
        }
        return string.substring(substringIndexes[0], substringIndexes[1]);
    }
            
    // Function that uses a sliding window to find a possible palindrome at each letter of the string
    public static void checkPalindrome(String string, int[] substringIndexes, int leftBoundary, int rightBoundary){
        int prevLeftIndex = substringIndexes[0];
        int prevRightIndex = substringIndexes[1];

        // We must use string.length()-1 because we are indexing
        while(leftBoundary >= 0 && rightBoundary <= string.length()-1){
            if(string.charAt(leftBoundary) == string.charAt(rightBoundary)){
                leftBoundary--;
                rightBoundary++;
                continue;
            }
            break;
        }

        // Due to the nature of the substring function's indexing, we need to add 1 to
        // the left boundary since it is a violation and will be included while rightBoundary
        // will not be (string.substring only goes up to the right boundary).
        if(rightBoundary-leftBoundary > prevRightIndex-prevLeftIndex){
            substringIndexes[0] = (leftBoundary + 1);
            substringIndexes[1] = rightBoundary;
        }
    }
            
    public static void main(String[] args){
        String word = args[0];
        String longestPalindromicSubstring = findPalindromicSubstring(word);
        System.out.println(longestPalindromicSubstring);
    }
}
