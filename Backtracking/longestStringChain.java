// Gist: Use backtracking to find chains for every word by deleting one char at a time and backtracking at each substring.
//      To save on complexity, we use a HashMap to save the longest substring possible for each substring in the case
//      we get the same substring again some other way.
//
//      This one is unique in the way that it uses a few transformations to make the algorithm possible such as turning
//      a string into a stringbuilder to allow for deleteCharAt and an array of words into a Set.
// TC: O(L^2 * n), where L is the longest length of a word and n is the number of words, SC: O(n)
class Solution {
    private int findLongestChain(String currWord, Set<String> wordBank, Map<String, Integer> memo){
        if(memo.containsKey(currWord)){
            return memo.get(currWord);
        }
        int longestChain = 1; // This is initially 1 because one letter counts as a single link in a chain.
        StringBuilder myWord = new StringBuilder(currWord);
        // Backtracking search for word detection and then recursion with substring
        // We are checking if every 1-char deletion at every position is possibly a word in the wordbank.
        for(int i = 0; i < currWord.length(); ++i){
            myWord.deleteCharAt(i);
            String newWord = myWord.toString();
            if(wordBank.contains(newWord)){
                int currChain = findLongestChain(newWord, wordBank, memo) + 1; // This +1 is also accounting for the first link.
                longestChain = Math.max(longestChain, currChain);
            }
            myWord.insert(i, currWord.charAt(i));
        }
        memo.put(currWord, longestChain);
        return longestChain;
    }
    public int longestStrChain(String[] words) {
        int longestChain = 0;
        // We will need a set to have reduced time complexity while detecting if a word exists in our given array
        Set<String> existenceBank = new HashSet<>();
        Map<String, Integer> computedChains = new HashMap<>();
        Collections.addAll(existenceBank, words);
        for(String word : words){
            longestChain = Math.max(findLongestChain(word, existenceBank, computedChains), longestChain);
        }
        return longestChain;
    }
}
