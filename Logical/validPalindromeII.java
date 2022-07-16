
// R: Gist: When a single mismatch is found, we have now lost a life/heart and are in the validPalindromePrime method (no lives left).
//      Basically, a forgiving validPalindrome two-pointers approach, then if a mismatch is found, we do the first unforgiving version of validPalindrome(Prime)
class Solution {
    public boolean validPalindromePrime(String s) {
        int str_len = s.length();
        for(int i = 0; i <= str_len/2; ++i){
            if(s.charAt(i) != s.charAt(str_len - (i + 1))){
                return false;
            }
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int str_len = s.length();
        for(int i = 0; i <= str_len/2; ++i){
            if(s.charAt(i) != s.charAt(str_len - (i + 1))){
                // R: The inner string with either side removed. We can simplyreturn the result as the answer.
                return validPalindromePrime(s.substring(i+1, str_len - (i))) || validPalindromePrime(s.substring(i, str_len - (i+1)));
            }
        }
        return true;
    }
};
