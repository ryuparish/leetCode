class Solution {
    
    // TC: O(n), SC: O(1)
     // Loop through finding characters from s in t in order, and check to find matching letters with two poitners.
     // Increment pointers accordingly and then stop if either pointer goes past their string's end.
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0){
            return true;
        }
        // Loop through finding characters from s in t in order.
        // Stop if either pointer goes past their string's end.
        int j = 0, i = 0;
        while (j < s.length() && i < t.length()){
            if (t.charAt(i) == s.charAt(j)){
                j++;
            }
            i++;
        }
        return j == s.length();
    }
}
