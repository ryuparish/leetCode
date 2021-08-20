// This is a 4-pointers problem
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        std::vector<int> myAnswers;
        int u = 0; // Translates to the upper row moving down
        int r = matrix.size() ? matrix[0].size() -1 : 0; // Translates to the rightmost column moving left
        int d = matrix.size() - 1; // Translates to the bottom row moving upwards
        int l = 0; // Translates to the leftmost column moving right
        // Representation of the pointers
        // L/U| | | | | | | | | R
        //   -------------------
        //    | | | | | | | | |
        //   -------------------
        //    | | | | | | | | |
        //   -------------------
        //  D | | | | | | | | |
        //
        //  The Crux:
        //      The movement of the top row moving left to right relies on the left and right pointers but also needs to increment the up pointer,
        //      since the that is representing the top row we iterate upon.
        while(l <= r && u <= d){
            // First loop across the top row 
            for(int col = l; col <= r; ++col){
                myAnswers.push_back(matrix[u][col]);
            }
            // Second loop down the last unexplored column
            // If the top left pointer is greater than the bottom right pointer, then we have finished
            if(++u > d){break;}
            for(int row = u; row <= d; ++row){
                myAnswers.push_back(matrix[row][r]);
            }
            if(--r < l){break;}
            // Third loop across the bottom
            for(int col = r; col >= l; --col){
                myAnswers.push_back(matrix[d][col]);
            }
            // Fourth loop upto the original starting position
            if(--d < u){break;}
            for(int row = d; row >= u; --row){
                myAnswers.push_back(matrix[row][l]);
            }
            if(l++ > r){break;}
        }
        return myAnswers;
    }
};
