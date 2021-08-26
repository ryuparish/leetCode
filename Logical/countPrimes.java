// Key Lemma:
//      A number is non-prime, iff the number is not a multiple of any of the numbers less than it and greater than 0.
// Original. There is another version but the solution has no explanation and it is a little complex
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] nonPrime = new boolean[n];
        //while(currNum <= n){
        for(int i = 2; i < n; ++i){
            if(!nonPrime[i]){
                count++;
                for(int j = 2; j*i < n; ++j){
                    nonPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
// Optimal Solution
//public int countPrimes(int n) {
//    if (n < 3)
//        return 0;
//        
//    boolean[] f = new boolean[n];
//    //Arrays.fill(f, true); boolean[] are initialed as false by default
//    int count = n / 2;
//    for (int i = 3; i * i < n; i += 2) {
//        if (f[i])
//            continue;
//        
          // This loop initialization works because if there was some number, a, that is
          // less than i and not prime, well it would be covered beforhand. (I stopped here)
//        for (int j = i * i; j < n; j += 2 * i) {
//            if (!f[j]) {
//                --count;
//                f[j] = true;
//            }
//        }
//    }
//    return count;
//}
