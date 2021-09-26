// Gist: We can keep a "max index" value as we traverse the string from left to right. We will continuously update this
// max index until we reach it. When we reach it we can count the string from previously found (or 0) max index
// to the currently reached max index. This is due to the fact that the partition will certainly contain all existing
// copies of the letter within it.

// You could rephrase this problem to be "create the segments with each segment having unique letters (duplicates allowed 
// within the segment only)"
class Solution {
    public List<Integer> partitionLabels(String s) {
        int maxIndex = 0, prevLast = 0;
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        
        // Finding the farthest index for each letter in the string
        for(int i = 0; i < s.length(); ++i){
            lastIndex.put(s.charAt(i), i);
        }
        
        // Adding a length everytime there is maxIndex equivalent to the current iterating index
        for(int i = 0; i < s.length(); ++i){
            maxIndex = Math.max(maxIndex, lastIndex.get(s.charAt(i)));
            // If the current index is the farthest that this segment goes
            if(maxIndex == i){
                answer.add((i+1) - prevLast);
                prevLast = i+1;
            }
        }
        return answer;
    }
}
