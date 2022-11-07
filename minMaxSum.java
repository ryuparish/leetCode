public static void miniMaxSum(List<Integer> arr) {
  // TC: O(n)
  long min = arr.get(0), max = arr.get(0), sum = 0;
  for(int i = 0; i < arr.size(); ++i) {
    long currInt = arr.get(i);
    min = Math.min(min, currInt);
    max = Math.max(max, currInt);
    sum += currInt;
  }
  System.out.println((sum - max) + " " + (sum - min));
}
