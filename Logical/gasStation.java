// Gist: The idea behind this algorithm requires two key lemmas:
    // 1. If the total gas is less than the total cost, any round trip from any position is impossible.
    // 2. Starting from the beginning of the lists, we can keep track of the current gas and if at any point the gas
    // becomes negative, we can just set the currGas to zero and set the next index as the startStation.
        // * You can rest assured this works because you will never skip over a valid spot as a potential start point.
        // This is because if you do not start on a point, but you cross over it, you would automatically have more 
        // gas than if you were to have started there (you would have n gas instead of 0).
// TC: O(n), SC: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, currGas = 0, startStation = 0;
        for(int i = 0; i < gas.length; ++i) {
            totalGas += (gas[i] - cost[i]);
            currGas += (gas[i] - cost[i]);
            if(currGas < 0) {
                startStation = i+1;
                currGas = 0;
            }
        }
        return totalGas < 0 ? -1 : startStation;
    }
}
