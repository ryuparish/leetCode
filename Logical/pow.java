// This one is too slow. There is a way to reduce the number of multiplications.
//class Solution {
//    public double myPow(double x, int n) {
//        double collector = 1.0;
//        long n_safe = n;
//        System.out.println("n_safe: " + n_safe + " Math.abs(n_safe): " + Math.abs(n_safe));
//        if(x != 1.0)
//            for(long i = 0; i < Math.abs(n_safe); ++i)
//                collector *= x;
//        if(n < 0)
//            return 1.0/collector;
//        return collector;
//    }
//}
class Solution{
	public double myPow(double x, int n) {
	    if(n == 0) return 1;
	    if(n == Integer.MIN_VALUE){
	        x = x * x;
	        n = n/2;
	    }
	    if(n < 0) {
	        n = -n;
	        x = 1/x;
	    }
	    // Instead of multiplying like this: 3 * 3 * 3 * 3...
	    // This multiplies like this ((3 * 3) * (3 * 3)) * (((3 * 3) * (3 * 3)) * ((3 * 3) * (3 * 3)))
	    //      We can half the n value each time because each time we are "powering" the current x value by
	    //      the current n/2.
	    //      2, 16 => 4, 8 => 16, 4 => 256 , 2 => 65536, 1 => return x * 1(one is return when 1/2[zero] is passed in as n)
	    return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
	}
}
