// Not optimal. Fails on lists of size 10000.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answers = new ArrayList<List<String>>();
		Map<Integer, Integer> isUsed = new HashMap<Integer, Integer>();
        int nextIndex = 0, matchCount = 0; 
        if(strs.length == 1){
            List<List<String>> singletonAnswer = new ArrayList<List<String>>();
            singletonAnswer.add(Arrays.asList(strs));
            return singletonAnswer;
        }
        // Dealing with different lengths of strings and strings that don't match at the same time
        while(isUsed.size() < strs.length){
            // Sorting the current word for matching with others
            // System.out.println("nextIndex: " + nextIndex + " isUsed.size(): " + isUsed.size());
            char[] currCharArray = strs[nextIndex].toCharArray();
            Arrays.sort(currCharArray);
            List<String> newAnagrams = new ArrayList<String>();
            newAnagrams.add(strs[nextIndex]);
            isUsed.put(nextIndex++, 1);
            for(int i = nextIndex; i < strs.length; ++i){
                matchCount = currCharArray.length;
                // If the current index is already used then skip it
                if(isUsed.containsKey(i)){continue;}
                // If the current string is different len than the current match, check if we can make a new
                // nextIndex 
                else if((strs[i].length() != currCharArray.length)){
                    if(isUsed.containsKey(nextIndex)){
                        nextIndex = i;
                    }
                }
                // If they are the same 
                char[] currMatch = strs[i].toCharArray();
                Arrays.sort(currMatch);
                boolean isMatch = String.valueOf(currMatch).equals(String.valueOf(currCharArray));
                if(isMatch){
                    newAnagrams.add(strs[i]);
                    isUsed.put(i, 1);
                }
                else if(isUsed.containsKey(nextIndex)){
                    nextIndex = i;
                }
            }
            answers.add(newAnagrams);
        }
        return answers;
    }
}
