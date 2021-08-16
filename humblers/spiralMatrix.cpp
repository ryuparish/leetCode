class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        std::vector<int> myAnswers;
        int u = 0;
        int r = matrix.size() ? matrix[0].size() -1 : 0;
        int d = matrix.size() - 1;
        int l = 0;
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
