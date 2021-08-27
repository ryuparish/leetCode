// This algorithm utilizes the fact that regardless of the letter shown, if the strings are isomorphic
// each time a unique letter in seen, the letter in the other word should also be unique.
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Up to 255 because the chars can be auto-converted to integers when map1[(some char)] is done
        int[] map1 = new int[255];
        int[] map2 = new int[255];
        int counter = 1;
        // Creating char arrays out of the given strings
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            // If the current letter is not the same "unique" number
            if (map1[sa[i]] != map2[ta[i]]) {
                return false;
            } 
            if (map1[sa[i]] == 0) {
                // counter signifies the count of the unique chars seen (or the "unique number")
                map1[sa[i]] = counter;
                map2[ta[i]] = counter;
                counter++;
            }
        }
        return true;
    }
}
