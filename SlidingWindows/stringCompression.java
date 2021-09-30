// Gist: The gist is to not use a for loop. We need to keep track of two separate pointers and make sure we increment them
// manually, as this problem demands that much control over the indexes. We keep track of an index, i, which will act as
// our leadHead and count dupes. The currIdx index will keep track of the corrected/rewritten index and also allow us to
// rewrite accurately.
// TC: O(n), SC: O(1)
class Solution {
    public int compress(char[] chars) {
        int currIdx = 0, i = 0;
        while(i < chars.length){
            char currChar = chars[i];
            int count = 0;
            while(i < chars.length && chars[i] == currChar){
                ++i;
                count++;
            }
            
            chars[currIdx++] = currChar;
            
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[currIdx++] = c;
                }
            }
        }
        return currIdx;
    }
}
