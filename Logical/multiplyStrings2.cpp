#include <iostream>
#include <string>
#include <vector>
class Solution{
public: 
    std::string multiply(std::string num1, std::string num2){
        std::vector<int> answer(num1.length() + num2.length(), 0);
        std::string answerString = "";
        for(int i = num1.size() - 1; i >= 0; --i){
            for(int j = num2.size() - 1; j >= 0; --j){
                // We need to keep track of the lag, lead, and sum.
                // We also need to make sure we have the correct char
                // Adding the offset of '0'
                int realDigit1 = num1[i] - '0';
                int realDigit2 = num2[j] - '0';
                int currProduct = (realDigit1 * realDigit2) + answer[(i + j) + 1];
                std::cout << "currProduct: " << currProduct << "\n";
                answer[j+i] += (int)(currProduct / 10);
                answer[j+i+1] = currProduct % 10;
            }
        }

        for(int i : answer){
            char digit = i + '0';
            answerString += digit;
        }
        size_t startHead = answerString.find_first_not_of("0");
        return startHead != std::string::npos ? answerString.substr(startHead) : "0";
    }
};

int main(){
    Solution mySolution = Solution();
    std::string num1 = "2";
    std::string num2 = "3";
    std::cout << mySolution.multiply(num1, num2) << "\n";
    return 0;
}
