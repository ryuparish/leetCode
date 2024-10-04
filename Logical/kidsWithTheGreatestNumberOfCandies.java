class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // First find the maximum value of candies
        int greatestNumberOfCandies = 0;
        for (int i = 0; i < candies.length; ++i){
            if (greatestNumberOfCandies < candies[i]){
                greatestNumberOfCandies = candies[i];
            }
        }

        // Then create the boolean array with another loop through the list
        List<Boolean> booleanArray = new ArrayList<>();
        for (int i = 0; i < candies.length; ++i){
            booleanArray.add(candies[i] + extraCandies >= greatestNumberOfCandies);
        }
        return booleanArray;
    }
}
