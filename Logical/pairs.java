public static int pairs(int k, List<Integer> arr) {
    // Write your code here
      Set<Long> diffFinder = new HashSet<>();
      int pairs = 0;
      // Adding all the unique values to our set from the List
      for(int i = 0; i < arr.size(); ++i) {
        diffFinder.add(new Long(arr.get(i)));
      }
      
      // Finding the complement needed among our set (just the values of our list)
      for (int i = 0; i < arr.size(); ++i) {
        Long target = new Long(arr.get(i) + k);
        if (diffFinder.size() != 0 && diffFinder.contains(target)){
          pairs++;
        }
      }
      
      return pairs;
    }
