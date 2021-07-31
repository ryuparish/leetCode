import java.lang.Math;
import java.util.*;
class Solution {
    // Iteratively check how many words ahead can fit into the line perfectly.
    // For the first n-1 lines:
        // Then, see if there are spaces left over and if they are divisible by the number of words on the line - 1.
        // If not, place and extra space in the first slot, check to see if it is divisible among the remaining spots, and if not continue
        // to place an extra space + truncated quotient. 
    // For the last line (check by seeing if placing the remaining words are possible):
        // Place the remaining words and spaces afterwords is necessary.
    
    // Returns either the perfect amount of words(singular spaces) and/or remaining words and/or amount of words with varied spaces needed.
    public int wordsThatCanFit(String[] words, int maxWidth, int currLength, int currWordIdx){
        int numWords = 0;
        while(currLength < maxWidth && currWordIdx < words.length){
            currLength += words[currWordIdx++].length() + 1;
            numWords++;
        }
        // We cannot fit all the words we counted, only up until the last one
        // Or we ran out of words.
        //System.out.println("numWords: " + numWords + " currLength: " + currLength);
        if(currLength > maxWidth){
            return --numWords;
        }
        return numWords;
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> answer = new ArrayList<String>();
        int currLength = 0, wordIdx = 0, numWords = 0, charCount = 0;
        
        // Loop until we run out of words
        while(wordIdx < words.length){
            StringBuilder sb = new StringBuilder();
            charCount = 0;
            
            // Add the first word
            sb.append(words[wordIdx++]);
            charCount += sb.length();
            currLength = sb.length();
            
            // Loop until we either find the optimal sb length
            // We add the words and the spaces to the string builder
            assert sb.length() < maxWidth: "The first word is longer than the maxWidth";
            int spaceCount = 1; 
            boolean evenSpaces = true;
            numWords = wordsThatCanFit(words, maxWidth, currLength, wordIdx);
            
            // Count up the amount of space that the words(not spaces) will take up
            for(int i = 0; i < numWords; ++i){
                charCount += words[wordIdx+i].length();
            }
            assert charCount + numWords <= maxWidth: "Addition of words and current line overflows maxWidth" + "\nnumWords: " + numWords + "\ncharCount: " + charCount + "\nsb.length(): " + sb.length();
            
            // We are short and we are not out of words(varied spaces or equal spaces)
            // Note: numWords+1 is the actual number of words since we added one before looping
            boolean perfect = (charCount + numWords) == maxWidth;
            boolean outOfWords = wordIdx+numWords >= words.length;
            if(numWords != 0 && !perfect && !outOfWords){
                // If the remaining spaces can be divided evenly
                if((maxWidth - charCount) % (numWords) == 0){
                    spaceCount = (maxWidth - charCount) / (numWords);
                }
                else{
                    spaceCount = (int)((maxWidth - charCount) / (numWords));
                    evenSpaces = false;
                }
                for(int i = 0; i < numWords; ++i){
                    // Getting the updated number of spaces remaining and seeing if they can be evenly split among the remaining words
                    if((numWords - i) > 0 && (maxWidth - (charCount + (i * (spaceCount+1)))) % (numWords - i) == 0){
                        evenSpaces = true;
                    }
                    if(!evenSpaces){
                        sb.append(" ".repeat(spaceCount+1));
                        // Check for divisibility of remaining line at end of for loop
                    }
                    else{
                        sb.append(" ".repeat(spaceCount));
                    }
                    sb.append(words[wordIdx++]);
                }
            }
            // n-1 line justification when one space is perfect
            else{
                for(int i = 0; i < numWords; ++i){
                    sb.append(" ");
                    sb.append(words[wordIdx++]);
                }
            }
            // Last line / one word justification
            if(outOfWords || numWords == 0){
                while(sb.length() < maxWidth){
                    sb.append(" ");
                }
            }
            answer.add(sb.toString());
        }
        return answer;
    }
        
    public static void main(String[] args){
        Solution mySolution = new Solution();
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		//String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        String[] words = {"What","must","be","acknowledgment","shall","be"};
		//int maxWidth = 20;
		int maxWidth = 16;
		List<String> answer = mySolution.fullJustify(words, maxWidth);
		for(int i = 0; i < answer.size(); ++i){
            System.out.println(answer.get(i));
        }
        return;
    }
}
