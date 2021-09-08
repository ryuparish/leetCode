// The differences between the numbers is the key to creating similarities between 
// shifted strings. We then either add the string to an existing list or to a new list of that group.
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        // Strings of integers to lists of Strings
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String word : strings){
            // Geting encoded version of the word
            String key = this.getKey(word);
            List<String> currList = map.getOrDefault(key, new ArrayList<>());
            currList.add(word);
            map.put(key, currList);
        }
        return new ArrayList<List<String>>(map.values());
    }

    private String getKey(String s) {
        StringBuilder currString = new StringBuilder();
        for(int i = 0; i < s.length()-1; ++i){
            // The smallest possible difference between two chars is -26
            // If the difference is negative, that negative space is the "negation space" of the loop
            // and we add it to 26
            int diff = s.charAt(i+1) - s.charAt(i);
            diff = diff >= 0 ? diff : diff+26;
            char code = (char)(diff+'0');
            currString.append(code);
        }
        return currString.toString();
    }
}
