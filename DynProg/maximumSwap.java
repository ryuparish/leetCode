// We keep track of index of the digits, with the leftmost index being kept when there are duplicates.
// TC: O(n), 
class Solution {
    public int maximumSwap(int num) {
        char[] numArray = Integer.toString(num).toCharArray();
        int[] digitArray = new int[10];
        for(int i = 0; i < numArray.length; ++i){
            digitArray[numArray[i] - '0'] = i;
        }
        for(int i = 0; i < numArray.length; ++i){
            for(int j = 9; j > numArray[i] - '0'; --j){
                // This only activates when the  largest number greater than the current number is
                // located after the current index i. It will also be the leftmost duplicate of this larger
                // number, guaranteeing that it will  be the leftmost, largest number that is larger than
                // the current value.
                if(digitArray[j] > i){
                    char temp = numArray[i];
                    numArray[i] = (char)(j+'0');
                    numArray[digitArray[j]] = temp;
                    return Integer.parseInt(new String(numArray));
                }
            }
        }
        return num;
    }
}
