class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagramCollector = new HashMap<String, List<String>>();
		for(int i = 0; i < strs.length; ++i){
            char[] currArray = strs[i].toCharArray();
            Arrays.sort(currArray);
            String currString = String.valueOf(currArray);
            if(!anagramCollector.containsKey(currString)){
                anagramCollector.put(currString, new ArrayList<String>());
            }
            anagramCollector.get(currString).add(strs[i]);
        }
        return new ArrayList<>(anagramCollector.values());
    }
}
