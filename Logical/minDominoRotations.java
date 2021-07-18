class Solution {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int topHighestFreq = 1, bottomHighestFreq = 1, mostFreqVal = 0, highestFrequency = 0;
        // Keep track of frequencies in separate lists for each row,
        // then add up each spot together to get the most freq value
        int[] topsCounter = new int[6];
        int[] bottomsCounter = new int[6];
        for(int i = 0; i < tops.length; ++i){
            topsCounter[tops[i] - 1] += 1;
            if(topsCounter[tops[i] - 1] > topHighestFreq){topHighestFreq = topsCounter[tops[i] - 1];}
            bottomsCounter[bottoms[i] - 1] += 1;
            if(bottomsCounter[bottoms[i] - 1] > bottomHighestFreq){bottomHighestFreq = bottomsCounter[bottoms[i] - 1];}
        }
        // To avoid the case where there are dominoes with double faces of the
        // most frequent face, we stop and return -1 if we flip and the value is not correct.
        for(int i = 0; i < topsCounter.length; ++i){
            if(topsCounter[i] + bottomsCounter[i] > highestFrequency){
                highestFrequency = topsCounter[i] + bottomsCounter[i];
                mostFreqVal = i + 1;
            }
        }
        if(highestFrequency < tops.length){return -1;}
        int[] flippingArray = topHighestFreq > bottomHighestFreq ? bottoms : tops;
        int[] swappingArray = topHighestFreq > bottomHighestFreq ? tops : bottoms;
        int swaps = 0;
        for(int i = 0; i < flippingArray.length; ++i){
            if(flippingArray[i] != mostFreqVal && swappingArray[i] != mostFreqVal){return -1;}
            if(flippingArray[i] == mostFreqVal && swappingArray[i] != mostFreqVal){
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args){
        int[] tops = {3, 5, 1, 2, 3};
        int[] bottoms = {3, 6, 3, 3, 4};
        int minRotations = minDominoRotations(tops, bottoms);
        System.out.println(minRotations);
        return;
    }
}
