public static String isBalanced(String s) {
    // Write your code here
      Stack<Character> charStack = new Stack<>();
      
      // TC: O(n), SC: O(n)
      // Looping across the string (every char)
      for (int i = 0; i < s.length(); ++i) {
        char currChar = s.charAt(i);
        // Checking for paren match
        if (currChar == ')') {
          if (charStack.isEmpty() || charStack.peek() != '('){
            return "NO";
          }
          charStack.pop();
        // Checking bracket match
        } else if (currChar == ']') {
          if (charStack.isEmpty() || charStack.peek() != '['){
            return "NO";
          }
          charStack.pop();
        // Checking for curly brace match
        } else if (currChar == '}') {
          if (charStack.isEmpty() || charStack.peek() != '{'){
            return "NO";
          }
          charStack.pop();
        } else {
          charStack.push(currChar);
        }
      }
      return charStack.isEmpty() ? "YES" : "NO";
    }
