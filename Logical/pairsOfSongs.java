// O(n^2) TC, O(1) SC
//class Solution {
//    public int numPairsDivisibleBy60(int[] time) {
//        int numPairs = 0;
//        for(int i = 0; i < time.length; ++i){
//            for(int j = i+1; j < time.length; ++j){
//                if((time[i] + time[j]) % 60 == 0){
//                    numPairs++;
//                }
//            }
//        }
//        return numPairs;
//    }
//}


// Gist: Tum Sum approach by using compliments and counter values. Saved time by using a int[] instead
//          of using a HashTable.
// O(n) TC, O(1) SC
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int numPairs = 0;
        int compliments[] = new int[60];
        for(int i = 0; i < time.length; ++i){
            numPairs += compliments[(60 - (time[i] % 60)) % 60];
            compliments[time[i] % 60]++;
        }
        return numPairs;
    }
}
