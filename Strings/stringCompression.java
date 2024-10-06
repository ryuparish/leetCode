class Solution {

    // TC: O(n), SC: O(n)
    // Kadanes algorithm modification for detecting groups of same letter then using pointer variables
    // to modify the current array. However, the logic for this algorithm is more concise when using while
    // loops, since you must control the pointer variables with finer granularity than what is easy with 
    // a for-loop.
    public int compress(char[] chars) {
        int currCharCount = 0, i = 0, res = 0;
        // Loop through all the letters left to right
        while(i < chars.length) {
            // Loop until we find the end of the current stretch
            currCharCount = 1;
            while (i + currCharCount < chars.length && chars[i+currCharCount] == chars[i]){
                currCharCount++;
            }

            // Place letter into array and place number too (if any)
            chars[res++] = chars[i];
            if (currCharCount > 1){
                for(char c : Integer.toString(currCharCount).toCharArray()){
                    chars[res++] = c;
                }
            }

            // Move the current i to the new letter
            i += currCharCount;
        }
        return res;
    }
}
