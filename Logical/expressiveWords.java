/ Gist: Use three functions, one to loop through every word and see how many are stretchy versions of the target,
// another to return the validity of stretchy-ness (based on the conditional below), and finally a function that
// returns the length of a stretch.
// TC: O(n), SC: O(1)
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; ++i){
            if(isStretched(words[i], s)){
                count++;
            }
        }
        return count;
    }
    
    private boolean isStretched(String s, String word){
        int i = 0, j = 0;
        while(i < s.length() && j < word.length()){
            if(s.charAt(i) != word.charAt(j)){return false;}
            int sLength = getLength(s, s.charAt(i), i);
            int wordLength = getLength(word, word.charAt(j), j);
            
            // Seeing if the strech qualifies
            if(wordLength < 3 && wordLength != sLength || wordLength >= 3 && wordLength < sLength){
                return false;
            }
            i += sLength;
            j += wordLength;
        }
        return i == s.length() && j == word.length() ? true : false;
    }
    
    private int getLength(String word, char letter, int index){
        int stretchLength = 0;
        while(index < word.length() && word.charAt(index++) == letter){
            stretchLength++;
        }
        return stretchLength;
    }
}
