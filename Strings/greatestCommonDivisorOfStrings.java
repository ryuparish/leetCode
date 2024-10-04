// TC: O(logn), SC: O(1)
// First check if the strings contain the same letters (using the .equals logic) then find gcd of string lengths.
class Solution {

    public int gcd(int str1Length, int str2Length) {
        // Found the largest common divisor number
        if (str2Length == 0){
            return str1Length;
        }
        // Still searching for largest common divisor number
        return gcd(str2Length, str1Length % str2Length);
    }

    public String gcdOfStrings(String str1, String str2) {
        // Simple logic check to see if strings are made up of the same
        // letters
        if (!(str1 + str2).equals(str2 + str1)){
            return "";
        }

        // Now we know they are made up of the same letters. Only need to find
        // the GCD of the lengths of the strings since we know their contents.
        int gcd = gcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }
}
