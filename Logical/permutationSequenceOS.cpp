#include <string>
#include <iostream>
#include <cstdlib>
#include <vector>
#include <cmath>

class Solution{
public:
    std::string getPermutation(int n, int k){
        std::string myAnswer = "";
        std::vector<int> choices;
        // Produce the vector of the numbers to choose from
        for(int i = 1; i <= n; ++i){
            choices.push_back(i);
        }

        // Get all the factorials out of convenience
        std::vector<int> factorials;
        factorials.push_back(1);
        int currFactorial = 1;
        // We wont need the factorial of n! , only up to it
        for(int i = 1; i < n; ++i){
            currFactorial *= i;
            factorials.push_back(currFactorial);
        }

        // Then we need to start the process of producing the string
        for(int i = 1; i <= n; ++i){
            int currIdx = (k-1)/(factorials[n-i]);
            myAnswer.append(std::to_string(choices[currIdx]));
            k -= currIdx * factorials[n-i];
            choices.erase(choices.begin() + currIdx);
        }
        return myAnswer;
    }
};

//int main(){
//    Solution mySolution = Solution();
//    int n = 4, k = 10;
//    std::string myAnswer = mySolution.getPermutation(n , k);
//    std::cout << myAnswer << "\n";
//    return 0;
//}
