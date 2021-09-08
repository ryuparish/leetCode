// If there exists a larger area within an index boundary(width), the minimum height of the towers at the index boundaries must exceed the minimum height of the previous index boundary towers by more than the difference of the widths. Picture on my phone for more mathematical explanation.
class Solution {
    public int maxArea(int[] height) {
        int endIndex = height.length - 1, beginIndex = 0, width, maximumArea = 0, area;
        while(endIndex - beginIndex > 0){
            width = endIndex - beginIndex;
            area = height[endIndex] > height[beginIndex] ? width*height[beginIndex++] : width*height[endIndex--];
            if(area > maximumArea){
                maximumArea = area;
            }
        }
        return maximumArea;
    }
}
