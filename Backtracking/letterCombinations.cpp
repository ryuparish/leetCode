#include <iostream>
#include <typeinfo>
#include <string>
#include <map>
#include <algorithm>
#include <vector>
class Solution {
public:
    std::vector<std::string> letterCombinations(std::string digits) {
        // Making the hashmap first
        std::map<char, std::string> numberToString;
        numberToString['2'] = "abc";
        numberToString['3'] = "def";
        numberToString['4'] = "ghi";
        numberToString['5'] = "jkl";
        numberToString['6'] = "mno";
        numberToString['7'] = "pqrs";
        numberToString['8'] = "tuv";
        numberToString['9'] = "wxyz";
        int i = 0, sizeOfList = 1, currNumCopies, numPreviousLetters = 1, repeatWindowStart, repeatWindowEnd;
        for(int j = 0; j < digits.size(); ++j){
            sizeOfList *= numberToString[digits[j]].size();
        }
        std::vector<std::string> listOfStrings;
        if(digits.size() == 0){listOfStrings.clear(); return listOfStrings;}
        currNumCopies = sizeOfList;
        while(i < digits.size()){
            std::string currString = numberToString[digits[i]];
            // Index of previous string
            // Looping each letter in the string o x p x q ... times for the previous multiples (1 if beginning)
            for(int a = 0; a < numPreviousLetters; ++a){
                repeatWindowStart = currString.size() * a;
                repeatWindowEnd = repeatWindowStart + currString.size();
                // Position of window
                // Looping every letter in the current string "numPreviousLetters" number of times while jumping currString.size() for every full loop
                for(int j = repeatWindowStart; j < repeatWindowEnd; ++j){
                    int copiesOfEach = (int)(currNumCopies / currString.size());
                    // Looping every letter in the string 
                    for(int k = 0; k < copiesOfEach; ++k){
                        listOfStrings[(j*copiesOfEach) + k] += currString[j % currString.size()];
                    }
                }
            }
            currNumCopies = (int)(currNumCopies / numberToString[digits[i]].size());
            numPreviousLetters *= currString.size();
            ++i;
        }
        return listOfStrings;
    }
};

int main(){
    Solution mySolution = Solution();
    std::string myString = "";
    std::vector<std::string> myAnswer = mySolution.letterCombinations(myString);
    for(int i = 0; i < myAnswer.size(); ++i){
        std::cout << myAnswer[i] << " ";
    }
    std::cout << "\n";
    return 0;
}
