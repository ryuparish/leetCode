class Solution {
    public String reverseVowels(String s) {
        int frontPointer = 0;
        int backPointer = s.length()-1;
        StringBuilder sb = new StringBuilder(s);

        // If the pointers cross, then we have done all the flips we need
        while (frontPointer < backPointer) {
            while (frontPointer < s.length() && !isVowel(s.charAt(frontPointer))){
                frontPointer++;
            }
            while (backPointer >= 0 && !isVowel(s.charAt(backPointer))){
                backPointer--;
            }
            if (backPointer > frontPointer) {
                char temp = s.charAt(frontPointer);
                sb.setCharAt(frontPointer, s.charAt(backPointer));
                sb.setCharAt(backPointer, s.charAt(frontPointer));
                frontPointer++;
                backPointer--;
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return (c == 'a' ||
            c == 'e' ||
            c == 'i' ||
            c == 'o' ||
            c == 'u');
    }
}
