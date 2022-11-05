// Gist: We use the fact that there are only a few recursive cases
//  that lead to partially full and completely full tile configurations.
class Solution {
    // Memoization for partial and full tiling configurations
    //
    // Longs are necessary because the addition of f and p would
    // possibly result in values larger than the 8 billion limit of an int.
    // 
    // If we return Longs instead, this overflow will not happen.
    // 
    // full and partial need to return longs to avoid the overflow (the two 
    // returns will add into a possible long) which mean memoVal needs to be
    // a long, and then the HashMap also needs to hold Longs since we are
    // storing memoVal and it would be about the same to convert it to int.
    Map<Integer, Long> fullMemo = new HashMap<Integer, Long>();
    Map<Integer, Long> partialMemo = new HashMap<Integer, Long>();
  
    private long partial(int n) {
      // Check for memoe'd values in partialMemo
      if (partialMemo.containsKey(n)) {
        return partialMemo.get(n);
      }
      
      long memoVal;
      
      // Base case
      if (n == 2) {
        memoVal = 1L;
      } else {
        memoVal = (full(n - 2) + partial(n - 1)) % 1000000007;
      }
      partialMemo.put(n, memoVal);
      return memoVal;
    }
  
    private long full(int n) {
      // Check for memoe'd values in fullMemo
      if (fullMemo.containsKey(n)) {
        return fullMemo.get(n);
      }
      
      long memoVal;
      
      // Base cases
      if (n == 1) {
        memoVal = 1L;
      } else if (n == 2) {
        memoVal = 2L;
      // Non-base cases
      } else {
        // Full case: Adding vertical domino onto full tiles that end in two vertical or
        // two horizontal dominoes.
        //
        // Partial case: Adding a backwards r tromino to partial tiles that are
        // missing a top rightmost tile.
        memoVal = (full(n - 1) + full(n - 2) + 2 * partial(n - 1)) % 1000000007;
      }
      fullMemo.put(n, memoVal);
      return memoVal;
    }
  
    // Init code
    public int numTilings(int n) {
      return (int) (full(n)); // Using cast to meet the method return value requirement
    }
}
