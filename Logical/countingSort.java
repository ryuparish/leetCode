public static List<Integer> countingSort(List<Integer> arr) {
    // Write your code here
      List<Integer> res = new ArrayList<Integer>(100);
      for (int i = 0; i < 100; ++i) {
        res.add(0);
      }
      for (int i = 0; i < arr.size(); ++i) {
        int currInt = arr.get(i);
        res.set(currInt, res.get(currInt) + 1);
      }
      return res;
    }
