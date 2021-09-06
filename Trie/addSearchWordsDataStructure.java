class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
    // Default empty constructor
    public TrieNode() {}
}
class WordDictionary {
    TrieNode mainTrie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        mainTrie = new TrieNode();
    }
    
    // Either adds words by making new char connections or by setting an existing subword
    // equal to true at the new word ending.
    public void addWord(String word) {
        TrieNode walker = mainTrie;
        for(char c : word.toCharArray()){
            // Adding char connection if it doesn't already doesn't exist
            if(!walker.children.containsKey(c)){
                walker.children.put(c, new TrieNode());
            }
            walker = walker.children.get(c);
        }
        walker.word = true;
    }
    
    public boolean searchInNode(String word, TrieNode node){
        // This iteration is used for the conditional to check whether we have any chars left
        // after the recursive calls, OR for iterating for each found char in the trie
        for(int i = 0; i < word.length(); ++i){
            char ch = word.charAt(i);
            // If the character is not contained in this TrieNode (either a dot or does not exist in mainTrie)
            if(!node.children.containsKey(ch)){
                // If wildcard
                if(ch == '.'){
                    // Recursing the trie in case the char is wildcard
                    // Backtracking dfs for the every letter in this trie
                    for(char c : node.children.keySet()){
                        TrieNode child = node.children.get(c);
                        // Searching the word with the first letter removed/finished
                        if(searchInNode(word.substring(i+1), child)){
                            return true;
                        }
                    }
                }
                // If not found 
                return false;
            }
            // If char is found
            else{
                node = node.children.get(ch);
            }
        }
        // Either by iteration when the char is found or by recursion where there is wildcard
        // we return the word boolean
        return node.word;
    }
    
    public boolean search(String word) {
        return searchInNode(word, mainTrie);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
