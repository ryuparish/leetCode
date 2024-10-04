// TC: O(n), SC: O(n)
// If character is a space, we add the corrected word to the sentence (with correct spacing) and we reset the built word.
// If character is not a space, we add a character to the reversed (because we are going backwards) word, but add if it is the last word.
class Solution {
    private void addWordWithSpacing(StringBuilder sentence, StringBuilder word) {
       if (sentence.length() == 0){
           sentence.append(word.reverse().toString());
       } else if (word.length() > 0){
           sentence.append(" " + word.reverse().toString());
       }
    }
    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = s.length()-1; i >= 0; i--){
            // If character is not a space
            if (s.charAt(i) != ' '){
                word.append(s.charAt(i));
                if (i == 0){
                    addWordWithSpacing(sentence, word);
                }
            // If character is a space
            } else {
                // Add word to the sentence
                addWordWithSpacing(sentence, word);
                word = new StringBuilder();
            }
        }
        return sentence.toString();
    }
}
