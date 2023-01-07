class Solution {
    public boolean reorderedPowerOf2(int n) {
       if (isPowerOf2(n)) {return true;}

       // Sorting the given integer
       String n_stringified = String.valueOf(n);
       char[] n_char_array = n_stringified.toCharArray();
       Arrays.sort(n_char_array);
       n_stringified = new String(n_char_array);

       // Note: i must be a long or else condition will never be false (it will just overflow)
       for (long i = 1; i <= Integer.MAX_VALUE; i*=2){
           // Current power of two sorted and stringified
           String curr_pot = String.valueOf(i);
           char[] curr_pot_array = curr_pot.toCharArray();
           Arrays.sort(curr_pot_array);
           curr_pot = new String(curr_pot_array);

           if (curr_pot.equals(n_stringified)){
               return true;
           }
       }
       return false;
    }

    public boolean isPowerOf2(int n){
        return Integer.bitCount(n) == 1;
    }
}
