class Solution {
    public int recurseBoundaries(int[] height, int maxHeight, int maxHeightIndex, int leftBoundary, int leftBoundaryIndex, int rightBoundary, int rightBoundaryIndex){
        // Base Case where we return 0 if the boundaries are both invalid
        if(leftBoundary == -1 && rightBoundary == -1){return 0;}
        boolean leftFound = false, rightFound = false;
        int rightSum = 0, leftSum = 0;
        if(leftBoundary != -1){
            // Getting the leftBoundary if it exists
            for(int i = maxHeightIndex - 1; i > -1; --i){
                if(height[i] > leftBoundary){
                    leftBoundaryIndex = i;
                    leftBoundary = height[i];
                    leftFound = true;
                }
                // Stopping early in the case that we find a pillar of the same height
                if(height[i] >= maxHeight){break;}
            }
            // Adding all the values up and recursing if a rain water was trapped
            if(leftFound){
                // Adding all the rain water to the left of maxHeightIndex
                for(int i = leftBoundaryIndex; i < maxHeightIndex; ++i){
                    leftSum += (leftBoundary - height[i]);
                }
                leftSum += recurseBoundaries(height, leftBoundary, leftBoundaryIndex, 0, 0, -1, 0);
            }
        }
        if(rightBoundary != -1){
            // Getting the rightBoundary if it exists
            for(int i = maxHeightIndex + 1; i < height.length; ++i){
                if(height[i] > rightBoundary){
                    rightBoundaryIndex = i;
                    rightBoundary = height[i];
                    rightFound = true;
                }
                // Stopping early in the case that we find a pillar of the same height
                if(height[i] >= maxHeight){break;}
            }
            if(rightFound != true){
                rightBoundary = -1;
            }
            else{
                // Adding all the rain water to the left of maxHeighIndex
                for(int i = rightBoundaryIndex; i > maxHeightIndex; --i){
                    rightSum += (rightBoundary - height[i]);
                }
                rightSum += recurseBoundaries(height, rightBoundary, rightBoundaryIndex, -1, 0, 0, 0);
            }
        }
        return rightSum + leftSum;
    }
        
    public int trap(int[] height) {
        if(height.length == 1 || height.length == 0){return 0;}
        int maxHeight = 0, maxHeightIndex = 0;
        // Finding max height
        for(int i = 0; i < height.length; ++i){
            if(height[i] > maxHeight){maxHeight=height[i];maxHeightIndex = i;}
        }
        //System.out.println("Here is the initial max height:" + maxHeight);
        return recurseBoundaries(height, maxHeight, maxHeightIndex, 0, 0, 0, 0);
    }

    //public static void main(String[] args){
    //    Solution mySolution = new Solution();
    //    //int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
    //    //int[] height = {4, 2, 0, 3, 2, 5};
    //    //int[] height = {2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
    //    int myAnswer = mySolution.trap(height);
    //    System.out.println(myAnswer);
    //}
}
