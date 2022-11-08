public static int superDigit(String n, int k) {
      // If there is only 1 digit in the current super digit
      if (n.length() == 1){return Integer.parseInt(n);}
      
      // Creating the next super digit
      long result = 0;
      for (int i = 0; i < n.length(); ++i) {
        result += Character.getNumericValue(n.charAt(i));
      }
      
      // Summing it k times as that will be the same as 
      // copying the string and adding the digits together
      result *= k;
      
      // Call the superDigit method but this time 
      return superDigit(String.valueOf(result), 1);
      
    }
