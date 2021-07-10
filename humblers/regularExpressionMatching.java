class Solution{
     public static int[] runAsterisk(String s, int string1Pointer, char selectedChar){
         // Run through the String s until it either runs out of characters or it
         // stumbles upon another letter
         char curr_char = ' ';
         int spotsMoved = 0;
         if(selectedChar == '.'){
             spotsMoved = (s.length() - 1) - string1Pointer;
             string1Pointer = s.length() - 1;
         }
         else{curr_char = selectedChar;}
         while(string1Pointer < s.length() && s.charAt(string1Pointer) == curr_char){
             spotsMoved++;
             string1Pointer++;
         }
         int[] positionAndSpots = {string1Pointer, spotsMoved};
         return positionAndSpots;
     }
 
     public static boolean isMatch(String s, String p){
         // String1 is the string to search and string 2 is the regular
         // expression
         int string1Pointer = 0, string2Pointer = 0, spotsMoved = 0;
         
         // Base Case where one of the strings is empty
         if(s.isEmpty()){
             int charCounter = 0, asteriskCounter = 0;
             while(string2Pointer < p.length()){
                 if(p.charAt(string2Pointer) == '*'){
                     asteriskCounter++;
                 }
                 else{charCounter++;}
                 string2Pointer++;
             }
             if(charCounter - asteriskCounter == 0){
                 return true;
             }
             return false;
         }
         else if(p.isEmpty()){
             return false;
         }
         char searchChar = ' ';
         int[] returnValues;
         // While we have not yet run out of the regular expression or the string
         while(string1Pointer < s.length() && string2Pointer < p.length()){
             // To check if there is possibly an asterisk
             if(string2Pointer + 1 < p.length()){
                 if(p.charAt(string2Pointer + 1) == '*'){
                     // First checking if it is a period
                     if(p.charAt(string2Pointer) == '.'){
                         // The checking if there is a letter afterwards. If not then it is a game ender. If so then, it can be treated like any other asterisk.
                         if(string2Pointer + 2 >= p.length()){
                             return true;
                         }
                     }
                     // Setting new string1Pointer after running the asterisk
                     searchChar = p.charAt(string2Pointer);
                     returnValues = runAsterisk(s, string1Pointer, searchChar);
                     string1Pointer = returnValues[0];
                     spotsMoved = returnValues[1];
                     // Moving two spots because we need to skip over the asterisk as well
                     string2Pointer += 2;
                     // Taking care of the case where the character after the asterisk is the same letter, possibly repeated. 
                     // If the spotsMoved is zero, there is no configurable valid combination anyway so we avoid it
                     while(string2Pointer < p.length() && p.charAt(string2Pointer) == searchChar && spotsMoved > 0){
                         spotsMoved--;
                         string2Pointer++;
                         // No valid configuration. Searching for more of the same character and there aren't anymore in this part of the string
                         if(spotsMoved < 0){
                             return false;
                         }
                     }
                     if(searchChar == '.'){
                         int newString1Pointer = -1, charCount = 0;
                         // Counting how many of the next-character matches we need in order for there to still be a chance of a match
                         for(int i = string2Pointer; i < p.length(); ++i){
                             if(p.charAt(i) ==  p.charAt(string2Pointer)){
                                 if(i+1 < p.length() && p.charAt(i+1) == '*'){
                                     continue;
                                 }
                                 charCount++;
                             }
                         }
                         // DEBUG
                         //System.out.println("Here is the value of string2Pointer:" + string2Pointer);
                         //System.out.println("Here is the next character:" + p.charAt(string2Pointer));
                         //System.out.println("Here is how many we need: " + charCount);
                         //
                         // Finding the spot to stop where charCount number of matches have been found (if that many exist)
                         int i;
                         for(i = 0; i <= spotsMoved; ++i){
                             if(s.charAt(string1Pointer - i) == p.charAt(string2Pointer)){
                                 // String1Pointer is now at the spot right after the matching character
                                 newString1Pointer = string1Pointer - (i - 1);
                                 charCount--;
                                 if(charCount == 0){
                                     break;
                                 }
                             }
                         }
                         // If did not find a match for the next letter, then there is no match in the rest of the list since ".*" is the rest of the list
                         // If we didn't find the corresponding number of chars, then it is also not possible to have a match since ".*" is the rest of the list
                         if((i > spotsMoved && newString1Pointer == -1)  || charCount != 0){
                             return false;
                         }
                         string1Pointer = newString1Pointer;
                         string2Pointer++;
                     }
                     // DEBUG
                     //System.out.println("After asterisk: string2Pointer: " + string2Pointer + " string1Pointer: " + string1Pointer);
                     //System.out.println("Here are the lengths of s: " + s.length() + " p: " + p.length());
                 }
                 else{
                     // If the letters match or if the letter is a period then increment both by 1
                     if(p.charAt(string2Pointer) == s.charAt(string1Pointer)){
                         string1Pointer++;
                         string2Pointer++;
                     }
                     // If the letters do not match and it is not a period
                     else if(p.charAt(string2Pointer) != s.charAt(string1Pointer) && p.charAt(string2Pointer) != '.'){
                         string2Pointer++;
                     }
                     // If they do not match and the regular expression is currently on an period
                     else{
                         string1Pointer++;
                         string2Pointer++;
                     }
                 }
             }
             // There is only one character left is string2 (I dont think it is possible for it to be an asterisk
             else{
                 if(s.charAt(string1Pointer) == p.charAt(string2Pointer)){
                     string1Pointer++;
                     string2Pointer++;
                 }
                 else if(p.charAt(string2Pointer) == '.'){
                     string1Pointer++;
                     string2Pointer++;
                 }
                 // Last letters do not match and there is only one letter left in the regular expression
                 else{
                     string2Pointer++;
                 }
             }
         }
 
         // If the string1Pointer is past the first string
         if(string1Pointer >= s.length() && string2Pointer >= p.length()){
             return true;
         }
 
         // If the string1Pointer is past the first string but string2Pointer is not yet finished
         else if (string2Pointer < p.length()){
             int asteriskCounter = 0, charCounter = 0;
             while(string2Pointer < p.length()){
                 if(p.charAt(string2Pointer) == '*'){
                     asteriskCounter++;
                 }
                 // On the chance that the letter found can be configured with an asterisk that possibly finished matched the entire search string
                 else if (p.charAt(string2Pointer) == searchChar){
                     spotsMoved--;
                     if(spotsMoved < 0){
                         return false;
                     }
                 }
                 else{
                     charCounter++;
                 }
                 string2Pointer++;
             }
             if(charCounter - asteriskCounter <= 0){
                 return true;
             }
         }
         return false;
     }
 
     public static void main(String[] args){
         String string1 = "bbbba";
         String string2 = ".*a*a";
         boolean answer = isMatch(string1, string2);
         System.out.println(answer);
     }
 }
