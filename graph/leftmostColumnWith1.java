/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

// TC: O(m+n) , SC: O(1)
// Gist: Go left when you encounter a 1 and record before you do.
// Then if you encounter a 0, just go straight down
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(0)-1;
        int i = 0, answer = -1;
        while(i < m && n >= 0){
            if(binaryMatrix.get(i, n) == 1){answer = n--;}
            else{i++;}
        }
        return answer;
    }
}
