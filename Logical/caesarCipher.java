public static String caesarCipher(String s, int k) {
 // Write your code here
   String alphabet = new String("abcdefghijklmnopqrstuvwxyz");
   StringBuilder cCipher = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
   
   // StringBuilder? -> (O(n*k)), Queue? (preferred) -> O(k)
   // Wrapping/Rotating the caesar cipher with given k.
   for (int i = 0; i < k; ++i){
     char currChar = cCipher.charAt(0);
     cCipher.deleteCharAt(0);
     cCipher.append(currChar);
   }
   
   
   // TC: O(n), SC: O(n)
   // Now actually building the string
   StringBuilder ans = new StringBuilder();
   for (int i = 0; i < s.length(); ++i) {
     char currChar = s.charAt(i);
     if (Character.isAlphabetic(currChar)){
       int alphabetIdx = -1;
       if (Character.isUpperCase(currChar)) {
         alphabetIdx = currChar - 'A';
         ans.append(Character.toUpperCase(cCipher.charAt(alphabetIdx)));
       } else {
         alphabetIdx = currChar - 'a';
         ans.append(cCipher.charAt(alphabetIdx));
       }
     } else {
       ans.append(currChar);
     }
   }
   return ans.toString();
}
