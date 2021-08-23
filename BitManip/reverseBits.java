public class Solution {
    // you need treat n as an unsigned value
    // Ryu:
    // The way to do this is to start with zero and then 
    // set the current lowest-bit to the lowest-bit in n.
    // We then need to shift the integer left (beginning at zero)
    // and shift n right. The way to see the lowest bit on n
    // is with n & 1. (AND with 1)
    public int reverseBits(int n) {
        int answer = 0;
        for(int i = 0; i < 32; ++i){
            // We must do answer <<= 1 at the beginning because 
            // we need 32 digits exactly. Doing it at the end
            // will make the first iteration have two: 10 , instead
            // of 1.
            answer <<= 1;
            answer += (n&1);
            n >>= 1;
        }
        return answer;
    }
}
