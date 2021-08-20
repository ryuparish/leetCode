// This is a 4-pointers problem
class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        std::vector< std::vector<int> > answer (n, std::vector<int>(n));
        int u = 0, l = 0, r = n -1, d = n -1, counter = 1;
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
            for(int col = l; col <= r; ++col){
                answer[u][col] = counter++;
            }
            if(++u > d){break;}
            for(int row = u; row <= d; ++row){
                answer[row][r] = counter++;
            }
            if(--r < l){break;}
            for(int col = r; col >= l; --col){
                answer[d][col] = counter++;
            }
            if(--d < u){break;}
            for(int row = d; row >= u; --row){
                answer[row][l] = counter++;
            }
            if(++l > r){break;}
        }
        return answer;
    }
};
