class Solution {
   public int largestRectangleArea(int[] heights) {

		int largestArea = 0;
        int width = 1;
        int currHeight = -1;
        int leftHead = i-1, rightHead = i+1;

        for(int i = 0; i < heights.length; ++i){
            width = 1;
            currHeight = heights[i];
            leftHead = i-1, rightHead = i+1;
            // Until both of the heads reach the bounds or are invalid
            while(leftHead >= 0 || rightHead < height.length){
                if(leftHead - 1 >= 0 && heights[leftHead-1] >= currHeight){
                    ++width;
                    --leftHead;
                }
                if(rightHead + 1 >= 0 && heights[rightHead+1] >= currHeight){
                    ++width;
                    ++rightHead;
                }
            }
            largestArea = currHeight * width > largestArea ? currHeight * width : largestArea;
        }
        //System.out.println(maxHeightIdx);
        return largestArea;
    }
}
