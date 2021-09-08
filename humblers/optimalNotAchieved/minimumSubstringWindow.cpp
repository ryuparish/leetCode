// Note: just iterating down the array o(n^2) down one side and then down the other side may guarantee finding the shortest length due to the "ignorance" advantage of either of the sides.
#include <string>
#include <iostream>
#include <cmath>
class Solution {
public:
   
    bool findChar(std::string &t_copy, char &searchChar){
        auto found = t_copy.find(searchChar);
        if(found != std::string::npos){
            t_copy.erase(t_copy.begin()+found);
            return true;
        }
        return false;
    }
    
    std::string minWindow(std::string s, std::string t) {
        std::string answer = "", t_copy;
        int smallestSize = 1000000, lastFoundLeft, lastFoundRight, leftHead, rightHead;
        // We make an expanding window at every letter, one side at a time, looking for either all the letters in the t string, stopping at the boundaries, or stopping if we grow the substring past the size of the current smallest size.
        for(int i = 0; i < s.size(); ++i){
            lastFoundLeft = -1;
            lastFoundRight = -1;
            leftHead = i;
            // Plus one to avoid duplicate counting and for looping the substring later
            rightHead = i + 1;
            
            // Make a copy of the string
            t_copy = t;
            // Searching both sides of the string for values of t until we find all values of if we reach the bounds
            // If there is no value found on the left side, the first right side will be the left side and vice versa
            std::cout << "Looping left\n";
            while(t_copy.size() > 0 && leftHead >= 0){
                std::cout << "on: " << s[leftHead] << "\n";
                // We save the first found left side in case we find nothing on the right side
                if(findChar(t_copy, s[leftHead--])){
                    std::cout << "Match\n";
                    if(lastFoundRight == -1){
                        lastFoundRight = leftHead +1;
                    }
                    lastFoundLeft = leftHead +1;
                } 
            }
            std::cout << "Looping right\n";
            while(t_copy.size() > 0 && rightHead < s.size()){
                // We save the first found right side if we find nothing on the left side
                std::cout << "on: " << s[rightHead] << "\n";
                if(findChar(t_copy, s[rightHead++])){
                    std::cout << "Match\n";
                    if(lastFoundLeft == -1){
                        lastFoundLeft = rightHead -1;
                    }
                    lastFoundRight = rightHead -1;
                } 
            }
            // We add 1 since they are indices and are off by one to represent size
            int currSize = (lastFoundRight - lastFoundLeft) +1;
            std::cout << "Current Size: " << currSize << "\n";
            std::cout << "Current smallestSize: " << smallestSize << "\n";
            if(t_copy.size() == 0 && currSize < smallestSize){
                answer.clear();
                std::cout << "answer set to: " << s.substr(lastFoundLeft, currSize) << "\n";
                answer = s.substr(lastFoundLeft, currSize);
                smallestSize = currSize;
            }
        }
        return answer;
    }
};

//int main(){
//    Solution mySolution = Solution();
//    std::string s = "ADOBECODEBANC";
//    //std::string s = "aa";
//    std::string t = "ABC";
//    //std::string t = "aa";
//    std::string myAnswer = mySolution.minWindow(s,t);
//    std::cout << myAnswer << "\n";
//    return 0;
//}
