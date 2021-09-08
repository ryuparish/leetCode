#include <string>
#include <iostream>
#include <algorithm>
class Solution {
public:
    int permutationNum = 1;
    std::string recurseString(std::string n, int k, int position){
        // As long as the position is indexible, recurse to find all
        // the permutations
        std::string answer = "null";
        if(position < (n.size() -1)){
            answer = recurseString(n, k, position+1);
            if(answer.compare("null") != 0){
                return answer;
            }
        }
        
        //if(position+1 >= n.size())std::cout << "Position " << position << " String: " << n << "\n";
        for(int i = position+1; i < n.size(); ++i){
            std::swap(n[position], n[i]);
            this->permutationNum++;
            //std::cout << "Position: " << position << " String: " << n << " Iteration: " << i - (position+1) << "\n";
            if(this->permutationNum == k){
                //std::cout << "Permutation found: " << n << "\n";
                return n;
            }
            answer = recurseString(n, k, position+1);
            if(answer.compare("null") != 0){
                return answer;
            }
        }
        // Returning dummy value that should actually never be returned
        return "null";
    }

    std::string getPermutation(int n, int k) {
        // Making the string version of the number 
        std::string newString;
        for(int i = 1; i <= n; ++i){
            newString.append(std::to_string(i));
        }
        // Base Case in case that it is only k = 1
        if(k == 1){return newString;}

        return recurseString(newString, k+1, 0); 

    }
};

//int main(){
//    Solution mySolution = Solution();
//    std::string myAnswer = mySolution.getPermutation(3, 2);
//    std::cout << myAnswer << "\n";
//    return 0;
//}
    
