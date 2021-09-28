// Gist: We need to check before we add a digit to the end of our return value if the answer will have an integer overflow.
// In order to do that, we will need to check for positive integer overflow and negative overflow, and if it does, we return
// 0. Otherwise we return the answer integer.
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int pop = x % 10;
            x /= 10;
            
            // If the current number is larger than or equal to 1 digit less than(on the left side) the MAX_INT value and the value to be
            // added is larger than 7, it will overflow
            if (rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE/ 10 && pop > 7) return 0;
            
            // If the current number is smaller than or equal to 1 digit less than(on the left side) the MIN_INT value
            // and the value to be added is smaller than -8, it will overflow
            if (rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE/ 10 && pop < -8) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
