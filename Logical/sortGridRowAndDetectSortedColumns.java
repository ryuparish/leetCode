public static String gridChallenge(List<String> grid) {
    // Write your code here
      // If there is only one string
      if (grid.size() == 1) {
        return "YES";
      }
      System.out.println(grid);
      
      // Sorting each ROW individually and setting the row to be sorted
      // version of itself.
      for (int i = 0; i < grid.size(); ++i) {
        char[] charArray = grid.get(i).toCharArray();
        Arrays.sort(charArray);
        grid.set(i, new String(charArray));
      }
      
      for (int i = 0; i < grid.get(0).length(); ++i) {
        // We can set the upper bound to grid.size() again since
        // this is a square matrix
        for (int j = 0; j < grid.size() - 1; ++j) {
          // Comparing two vertically adjacent characters
          if (grid.get(j).charAt(i) > grid.get(j+1).charAt(i)) {
            return "NO";
          }
        }
      }
      return "YES";
}
