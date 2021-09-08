// This method is actually too slow and bit manipulation is needed for a quicker solution
class Solution {
//    public int divide(int dividend, int divisor) {
//        int charge = 0, quotient = 0;
//        boolean overflow = false;
//        // In the case that the dividend was an int overflow negatively.
//        if(dividend <= Integer.MIN_VALUE && (divisor == 1 || divisor == -1)){overflow = true;}
//        for(int i = 0; !overflow && i < Math.abs(dividend); ++i){
//            charge++;
//            if(charge == Math.abs(divisor)){
//                if(quotient ==  2147483646){
//                    overflow = true; 
//                    break;
//                }
//                quotient++;
//                charge = 0;
//            }
//        }
//        
//        // If there was in overflow
//        if(overflow){
//            if((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0)){
//                return -2147483648;
//            }
//            return 2147483647;
//        }
//        // If things went regularly
//        if((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0)){
//            return -quotient;
//        }
//        return quotient;
//    }

	public static void main(String[] args){
		Solution mySolution = new Solution();
		int myAnswer = mySolution.divide(16, 2);
		System.out.println(myAnswer);
		return;
    }
// Bit Manipulation solution
	public int divide(int A, int B) {
	    if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
	    int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
	    while (a - b >= 0) {
            // Very compact for loop that does all the calculation necessary within it's definition
            // The condition is when the next x(which is the number of bit shifts) would cause b to be larger than or equivalent to a
            // Changing this to b << (x+1) will actually slow the program down so much that it will exceed the time limit
	        for (x = 0; a - (b << x << 1)) >= 0; x++);
            // We then add this bit shift amount in it's numerical form to res and then subtract it from a.
            // So if would be like this:
            // "We can subtract a by 2^x * b? Add 2^x to the result then subtract from a and check again until a is zero 
            // or a remainder that would result in a negative number if subtracted by b remains"
	        res += 1 << x; 
	        a -= b << x;
	    }
	    return (A > 0) == (B > 0) ? res : -res;
	}
}
