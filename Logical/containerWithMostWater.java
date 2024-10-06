class Solution {
    // The gist of this is to optimize to see all of the largest areas possible.
    // There are 9 different events, move [smaller, larger, equal] to [smaller, larger, equal]
    // heights. The only possible way to see larger AREAS are to move the smaller -> larger height,
    // since we are limited by the smaller height.
    // TC: O(n), SC: O(1)
    public int maxArea(int[] height) {
        int frontPointer = 0, backPointer = height.length-1, maxArea = 0;
        while(frontPointer < backPointer){
            int area = Math.min(height[backPointer], height[frontPointer]) * (backPointer - frontPointer);
            if (area > maxArea){
                maxArea = area;
            }

            // If left is larger or equal to right, move backpointer
            if (height[frontPointer] >= height[backPointer]){
                backPointer--;
            } else {
                frontPointer++;
            }
        }
        return maxArea;
    }
}
