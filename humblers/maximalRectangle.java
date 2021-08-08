class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0){return 0;}
        int n = matrix[0].length;

        // Initializing all the dp arrays
        int[] height = new int[matrix[0].length];
        int[] rightBounds = new int[matrix[0].length];
        int[] leftBounds = new int[matrix[0].length];
        Arrays.fill(rightBounds, matrix[0].length);

        int maxArea = 0;

        // Calculating the max area
        for(int i = 0; i < m; ++i){
            int currLeft = 0, currRight = n;
            // incrementing the height
            for(int j = 0; j < n; ++j){
                if(matrix[i][j] == '1'){height[j]++;}
                else{height[j] = 0;}
            }
            // Incrementing the width
            for(int j = 0; j < n; ++j){
                // The left bound for the current position is the max of either the same bound as the
                // bound above the current position (to maintain a rectangle) or the current position.
                if(matrix[i][j] == '1'){leftBounds[j] = Math.max(leftBounds[j], currLeft);}
                else{leftBounds[j] = 0; currLeft = j+1;}
            }
            // Incrementing the width
            for(int j = n-1; j >= 0; --j){
                // The right bound for the current position is the min either the same bound as the
                // bound above the current position (to maintain a rectangle) or the current position+1.
                if(matrix[i][j] == '1'){rightBounds[j] = Math.min(rightBounds[j], currRight);}
                else{rightBounds[j] = n; currRight = j;}
            }
            for(int j = 0; j < n; ++j){
                maxArea = Math.max(maxArea, height[j] * (rightBounds[j] - leftBounds[j]));
            }
        }
        return maxArea;
    }
}
