public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
      int TLtoBR = 0;
      int BLtoTR = 0;
      // Collect both sums at the same time.
      for (int i = 0; i < arr.size(); ++i) {
        TLtoBR += arr.get(i).get(i);
        BLtoTR += arr.get(arr.size() - (1 + i)).get(i);
      }
      return Math.abs(TLtoBR - BLtoTR);
    }
