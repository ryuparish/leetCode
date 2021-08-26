// midIndex(1-dimensional) = (lastIndex - firstIndex)/2
// m x n - 1 = last index, 0 = first index, matrix[midIndex/(n)][midIndex%n] = midValue
// Binary Search Edge Case Covering:
//  1. Start the ends just outside the boundary (-1, n)
//  2. Continue until there is no space between the bounds (endIdx - startIdx > 1)
//  3. Set each to the middle value instead of -1 or +1 of mid.
// TC: O(logn) SC: O(1)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int midIdx, n = matrix[0].length;
        int startIdx = -1, endIdx = (matrix.length * n);
        while(endIdx - startIdx > 1){
            midIdx = (endIdx + startIdx)/2;
            if(matrix[midIdx/n][midIdx%n] == target){return true;}
            else if(matrix[midIdx/n][midIdx%n] > target){endIdx = ((midIdx/n) * n) + (midIdx%n);}
            else{startIdx = ((midIdx/n) * n) + (midIdx%n);}
        }
        return false;
    }
}

// More modular version
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int midIdx, midRow, midColumn, n = matrix[0].length;
        int startIdx = -1, endIdx = (matrix.length * n);
        while(endIdx - startIdx > 1){
            midIdx = (endIdx + startIdx)/2;
            midRow = midIdx/n;
            midColumn = midIdx%n;
            if(matrix[midRow][midColumn] == target){return true;}
            else if(matrix[midRow][midColumn] > target){endIdx = (midRow * n) + (midColumn);}
            else{startIdx = (midRow * n) + (midColumn);}
        }
        return false;
    }
}
