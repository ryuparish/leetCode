public static int palindromeIndex(String s) {
// Write your code here
  int lagHead = 0;
  int leadHead = s.length()-1;
  for (int i = 0; i < s.length(); ++i) {
    if (s.charAt(lagHead) != s.charAt(leadHead)) {
      int frontChecker = lagHead+1;
      int backChecker = 0;
      // One-sided (yet symmetrical)
      while (s.charAt(frontChecker) == s.charAt(leadHead - backChecker)) {
        frontChecker++;
        backChecker++;
        // If there is a palindrome from lagHead+1 to leadHead,
        // the character at lagHead is the problematic one.
        if (frontChecker >= (leadHead - backChecker)) {
          return lagHead;
        }
      }
      // If there is not a palindrom from lagHead+1 to leadHead,
      // the only other conclusion is that leadHead is the problematic one
      // and it is not palindromic because of the char at leadHead.
      return leadHead;
    }
    --leadHead;
    ++lagHead;
  }
  return -1;
}
