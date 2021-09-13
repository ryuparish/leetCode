class Solution {
// Bit Manipulation solution
	public int divide(int A, int B) {
	    if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
	    int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        // We will enter this loop with a being greater than or equal to b (res == greater or equal to 1)
	    while (a - b >= 0) {
            // Changing this to b << (x+1) will actually slow the program down so much that it will exceed the time limit
            // Bit shift operations are read from left to right, so first num gets shifted x times then one
            // more time.
	        for (x = 0; a - (b << x << 1) >= 0; x++);
            // This operation works for odd numbers because we would calculate the k in (2k + 1) and then add 1.
	        res += 1 << x; 
	        a -= b << x;
	    }
	    return (A > 0) == (B > 0) ? res : -res;
	}
}

