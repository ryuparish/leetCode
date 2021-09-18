// This solution is much slower due to + and string, although the time complexity is the same
// TC: O(n) SC: O(n) 
//class Solution {
//    public String reverseWords(String s) {
//        int left = 0, right = s.length()-1;
//        
//        // Removing the white space
//        while(s.charAt(left) == ' '){left++;}
//        while(s.charAt(right) == ' '){right--;}
//        
//        String answer = new String("");
//        StringBuilder currWord = new StringBuilder();
//        
//        // It is okay if they overlap, just not if they cross
//        while(left <= right){
//            char currChar = s.charAt(left++);
//            
//            // Add word char if we reach a char to the current string
//            if(currChar != ' '){currWord.append(currChar);}
//            
//            // If we reach a space and there wasn't a space previously right before this,
//            // then we add a wrod
//            else if(currChar == ' ' && currWord.length() != 0){
//                
//                // If the answer is not set, then the current word is the answer
//                if(answer.length() == 0){answer = currWord.toString();}
//                
//                // If the answer if partially built, then we add a space (the last one happens
//                // outside this while loop)
//                else{answer = currWord.toString() + " " + answer;}
//                
//                // Reset the length of the current word
//                currWord.setLength(0);
//            }
//        }
//        
//        answer = currWord.toString() + " " + answer;
//        
//        // If it was only one word, then we remove the space
//        if(answer.length() == s.length()+1){answer = currWord.toString();}
//        
//        return answer.length() == 0 ? new String() : answer;
//    }
//}

// TC: O(n) SC: O(n) 
class Solution {
  public String reverseWords(String s) {
    int left = 0, right = s.length() - 1;
    // remove leading spaces
    while (left <= right && s.charAt(left) == ' ') ++left;

    // remove trailing spaces
    while (left <= right && s.charAt(right) == ' ') --right;

    Deque<String> d = new ArrayDeque();
    StringBuilder word = new StringBuilder();
    // push word by word in front of deque
    while (left <= right) {
      char c = s.charAt(left);

      if ((word.length() != 0) && (c == ' ')) {
        d.offerFirst(word.toString());
        word.setLength(0);
      } else if (c != ' ') {
        word.append(c);
      }
      ++left;
    }
    d.offerFirst(word.toString());

    return String.join(" ", d);
  }
}
