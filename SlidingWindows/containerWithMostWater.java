// The solution is a greedy approach, where we move inward whichever side has the smallest tower and calculate the area.
//
// The optimal solution is the largest pillar that could be the smaller side with the largest width.
//
// This works because the only possible way to get a greater value is if the smaller side was larger decrement of the width was still large enough to allow the largest area.
// Moving the larger pillar would only decrease the area, as the smaller side is the contraint.
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
