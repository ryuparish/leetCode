// The layout of this question is confusing, but there is only one list of words, so a sorted
// list of indices for each word can be created trivially by location in the list.

// Gist: We loop through the list and then look at all of indices of that word and then 
// use a hashmap to map each word to it's indice list. Then when comparing words, we use a
// two-pointers approach to find the shortest distance (similar to median of two arrays)


// Original Solution that is too complex and slow.
// TC: O(n^2), SC: O(n^2)
//class WordDistance {
//    Map<String, Map<String, Integer>> wordDistances;
//
//    public WordDistance(String[] wordsDict) {
//        this.wordDistances = new HashMap<String, Map<String, Integer>>();
//        
//        // Giving each word their respective length with the other words
//        for(int i = 0; i < wordsDict.length; ++i){
//            this.wordDistances.putIfAbsent(wordsDict[i], new HashMap<String, Integer>());
//            Map<String, Integer> currDict = wordDistances.get(wordsDict[i]);
//            
//            for(int j = i+1; j < wordsDict.length; ++j){
//                
//                if(j-i < currDict.getOrDefault(wordsDict[j], Integer.MAX_VALUE)){
//                    currDict.put(wordsDict[j], j-i);
//                    // Also add the opposite distance for the other word
//                    this.wordDistances.putIfAbsent(wordsDict[j], new HashMap<String, Integer>());
//                    this.wordDistances.get(wordsDict[j]).put(wordsDict[i], (j-i));
//                }
//            }
//        }
//    }
//    
//    public int shortest(String word1, String word2) {
//        return this.wordDistances.get(word1).get(word2);
//    }
//}

// TC: O(n + m), SC: O(x^2), where x is the number unique words in wordsDict
class WordDistance {
    Map<String, ArrayList<Integer>> wordDistances;

    public WordDistance(String[] wordsDict) {
        this.wordDistances = new HashMap<String, ArrayList<Integer>>();
        
        // TC: O(n), where n is the length of the wordsDict
        // Giving each word their respective array of indices
        for(int i = 0; i < wordsDict.length; ++i){
            ArrayList<Integer> indiceList = this.wordDistances.getOrDefault(wordsDict[i], new ArrayList<Integer>());
            indiceList.add(i);
            this.wordDistances.put(wordsDict[i], indiceList);
        }
    }
    
    // TC: O(n + m) where n is the length of word1 and m is length of word2
    public int shortest(String word1, String word2) {
        List<Integer> wordIndices1 = this.wordDistances.get(word1);
        List<Integer> wordIndices2 = this.wordDistances.get(word2);
        int head1 = 0, head2 = 0, minDistance = Integer.MAX_VALUE;
        while(head1 < wordIndices1.size() && head2 < wordIndices2.size()){
            int indice1 = wordIndices1.get(head1), indice2 = wordIndices2.get(head2);
            if(indice1 < indice2){
                minDistance = Math.min(minDistance, indice2 - indice1);
                head1++;
            }
            else{
                minDistance = Math.min(minDistance, indice1 - indice2);
                head2++;
            }
        }
        return minDistance;
    }
}


/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
