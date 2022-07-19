// R: Gist: This one is all about the edge cases, which all have a somewhat of a unique way of getting handled (re-arranging, duplicating, swapping) in the code.
// R: You can use two pointers, one to traverse the abbr and one to traverse the regular text word. Then, you can read when a number appears, then you can jump and check for the
// R: many possible states that the data could be in at that point. Repeat and you can imagine what the remaining cases would look like.

// R: TC: O(n), where n is the length of the abbreviated word.
// R: SC: O(1), no data grows except for static integer.

class Solution {
    
    public boolean validWordAbbreviation(String word, String abbr) {
        
        // R: For handling the "longer abbr case"
        if (abbr.length() > word.length()) {return false;}
        
        // R: For handling the character in question
        char currChar;
        
        int j = 0;
        // R: Loop the word 
        for(int i = 0; i <= abbr.length(); ++i, ++j) {
            
            // R: Full word matched
            if(i == abbr.length()) {break;}

            // R: Getting the current character FROM THE ABBR
            currChar = abbr.charAt(i);

            // R: Jump time. We need to read in the number first.
            if(Character.isDigit(currChar)) {

                // R: Check for zero
                if(currChar == '0'){return false;}

                // R: Read in the number
                int num = 0;
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i)))
                    num = (num*10) + Character.getNumericValue(abbr.charAt(i++));

                // R: Check if the number is over the remaining count of letters
                int remainingCount = word.length() - j;
                if (remainingCount < num) {return false;}

                // R: Check if the exact number is remaining
                if (remainingCount == num)
                    return i == abbr.length();

                // R: Check if we can jump to the spot and if the char there matches the next one.
                if ( num < remainingCount) {

                    j += num; // R: Jump the amount given from the abbr version of the word

                    // R: Either the abbr version did not have enough to match or
                    // R: the landing letter from the jump is a mis
                    boolean notEnough = i >= abbr.length();
                    if (notEnough || word.charAt(j) != abbr.charAt(i))
                        return false;
                }
            }
            
            
            // R: Just a letter, we can match and keep going
            else {
                
                // R: Checking for if the length was increased with the numbers in the abbr
                boolean abbrLong = j >= word.length();
                if((abbrLong) || (abbr.charAt(i) != word.charAt(j))) {return false;}
            }
        }
        
        if (j < word.length()) {return false;}
        return true;
    }
}
