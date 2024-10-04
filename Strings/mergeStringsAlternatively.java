// TC: O(m + n), SC: O(m + n)
// Use while loops to burn both strings, then use while loops to burn individual strings if they are longer than the other.
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Pointer = 0, word2Pointer = 0;
        StringBuilder res = new StringBuilder();

        // While both words have characters left
        while (word1Pointer < word1.length() && word2Pointer < word2.length()) {
            res.append(word1.charAt(word1Pointer++));
            res.append(word2.charAt(word2Pointer++));
        }

        // While word 1 has characters left
        while (word1Pointer < word1.length()) {
            res.append(word1.charAt(word1Pointer++));
        }

        // While word 2 has characters left
        while (word2Pointer < word2.length()) {
            res.append(word2.charAt(word2Pointer++));
        }
        return res.toString();
    }
}
