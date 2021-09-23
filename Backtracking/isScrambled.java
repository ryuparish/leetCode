// This solution is too slow and will not pass, although I do think it would work.
// Stop will be initialized at length for the s1.substr line error
// Start + i will be allowed to go up to length - 1 
//class Solution {
//    int maxSplits;
//    public boolean findScramble(String s1, String s2, int start, int stop){ 
//        // Base Case where the strings match or if the maximum number of splits is reached
//        if(s1.equals(s2)){
//            return true;
//        }
//        // Base Case where the max number of splits is reached
//        if(stop - start <= 1){
//            return false;
//        }
//        // Iterating/Simulating the splits and switches
//        // i + space will equal the current split choice
//        for(int i = 1; start + i < stop; ++i){
//            // Non-Swap
//            // First partition and second partition
//            if(findScramble(s1, s2, start, start+i) || findScramble(s1, s2, start+i, stop)){
//                return true;
//            }
//            
//            // Simulate Swap
//            String firstString = s1.substring(0,start);
//		    String firstChunk = s1.substring(start, start+i);
//			String lastChunk = s1.substring(start+i, stop);
//            s1 =  lastChunk + firstChunk;
//            if(s1.length() < s2.length()){
//                s1 = firstString + s1;
//            }
//            
//            // Method 2 (condensed)
//            // First partition and second partition
//            if(findScramble(s1, s2, start, start+i) || findScramble(s1, s2, start+i, stop)){
//                return true;
//            }
//            // Simulate Swap-Back
//            s1 =  firstChunk + lastChunk;
//            if(s1.length() < s2.length()){
//                s1 = firstString + s1;
//            }
//        }
//        return false;
//    }
//        
//    public boolean isScramble(String s1, String s2) {
//        boolean answer = findScramble(s1, s2, 0, s1.length());
//        return answer;
//    }
//}

// This solution passes
class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        String key = sb.toString();
        
        // Checking for finding after recursive call
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        // Checking for equality
        if (s1.equals(s2)) {
            map.put(key, true);
            return true;
        }
        
        // Making sure that they qualify to be a possible string scramble pair
        // Counting all of the letters in each of the substrings
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        // Looping for a possible mismatch in the count of letters for each string
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                map.put(key, false);
                return false;
            }
        }
        
        // The goal with this loop is the find a either:
        // First Recursive Conditional:
        //      - A match with the both growing beginnings and both shrinking ends
        // Second Recursive Conditional:
        //      - A match with growing opposing-and-other-string ends and shrinking opposing-and-other-string ends
        //      - This one is confusing, but is checking (in a different order) whether the
        //      first half of the first string and the second half of the second string match instead of
        //      first and first and second and second like the first conditional.
        //          * It is meant to check(in a different order) if the swap would make the strings match
        for (int i = 1; i < s1.length(); i++) {
            // Checking from first half of the strings and the second half of the strings
            if ( isScramble(s1.substring(0,i), s2.substring(0,i)) 
               && isScramble(s1.substring(i), s2.substring(i)) ) {
                map.put(key, true);
                return true;
            }
            // Checking from growing ends and from shrinking ends
            if ( isScramble(s1.substring(0,i), s2.substring(s1.length() - i)) 
               && isScramble(s1.substring(i), s2.substring(0,s1.length() - i)) ) {
                map.put(key, true);
                return true;
            }
        }
        
        map.put(key, false);
        return false;
    }
}
