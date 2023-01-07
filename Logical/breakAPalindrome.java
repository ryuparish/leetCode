class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        boolean isOdd = (n % 2) != 0;
        if (n == 1){return "";}
        for (int i = 0; i < n; ++i){
            if (palindrome.charAt(i) != 'a' && (isOdd ? (i != n/2) : true)) {
                StringBuilder ans = new StringBuilder(palindrome);
                ans.setCharAt(i, 'a');
                return ans.toString();
            } else if (i == n-1) {
                StringBuilder ans = new StringBuilder(palindrome);
                ans.setCharAt(i, 'b');
                return ans.toString();
            }
        }
        return null;
    }
}
