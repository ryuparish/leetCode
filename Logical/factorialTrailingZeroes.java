// Original Solution that will result in integer overflow
//class Solution {
//    public int factorial(int n){
//        return n == 1 || n == 0 ? 1 : n * factorial(n-1);
//    }
//    public int trailingZeroes(int n) {
//        int factorialNum = factorial(n);
//        int numZeroes = 0;
//        int modulo = 10;
//        while(factorialNum % modulo == 0){
//            numZeroes++;
//            modulo *= 10;
//        }
//        return numZeroes;
//    }
//}

// Math solution
class Solution{
    public int trailingZeroes(int n){
        // This works because for every 5 in the n!, there is a 2 that will go with it. Since every trailing zero
        // will result from a(5 * 2) * (all the other n numbers), we can just find all of the 5s and we will get the
        // correct number of trailing zeroes.
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
