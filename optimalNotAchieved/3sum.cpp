#include <vector>
#include <iostream>
#include <map>
#include <list>
#include <algorithm>
// This is the wrong way to approach it. Unless you use a linked list in each hashmap value. This is very hard to implement in C++ and will take a long time. The other solution is much simpler and less complex. God forbid you may need to delete and item from the linked hashmap once you make it. This a bit of a weakness with C++.
struct link{
    int index;
    link* next = NULL;
};

class Solution {
public:
    std::vector<std::vector<int>> threeSum(std::vector<int>& nums) {
        std::vector< std::vector<int> > answers;
        std::map<int, link*> remainderToIndex;
        int ivalue;
        bool safe = true;
        // Add all the indexes and the values to the map
        for(int i = 0; i < nums.size(); ++i){
            link* newLink = new link;
            newLink->next = NULL;
            link* walker = remainderToIndex[nums[i]];
            if(walker == NULL){
                std::cout << "Value add to hashmap: " << nums[i] << "\n";
                remainderToIndex.insert({nums[i], newLink});
                continue;
            }
            while(walker->next != NULL){
                walker = walker->next;
            }
            walker->next = newLink;
        }
        // Printing out all the value of the hashmap
        std::cout << "Here are the value in the hashmap:\n";
        for(auto pairs : remainderToIndex){
            std::cout << pairs.second << " ";
        }
        std::cout << "\n";
        // First set up and outer loop to find the fixed position
        for(int i = 0; i < nums.size(); ++i){
            std::cout << "Current nums[i]: " << nums[i] << "\n";
            ivalue = nums[i];
            for(int j = 0;  j < nums.size(); ++j){
                std::cout << "Current nums[j]: " << nums[j] << "\n";
                safe = true;
                // Checking if there is a value that matches the complement of the currSum + nums[j] to be 0.
                if(j == i){continue;}
                std::cout << "Here is the value we are searching the for: " << -(ivalue + nums[j]) << "\n";
                std::cout << "Here is the value we get when we index the hashmap for it: " << remainderToIndex[-(ivalue + nums[j])] << "\n";
                if(remainderToIndex[-(ivalue + nums[j])]){
                    link* walker = remainderToIndex[-(ivalue + nums[j])];
                    while(walker != NULL && walker->index != j && walker->index != i){
                        std::vector<int> newVector = {ivalue, nums[j], nums[walker->index]};
                        std::sort (newVector.begin(), newVector.end());
                        for(int k = 0; k < answers.size(); ++k){
                            if(newVector == answers[k]){
                                safe = false;
                                break;
                            }
                        }
                        if(safe){
                            answers.push_back(newVector);
                        }
                    }
                }
            }
        }
        return answers;
    }
};

int main(){
    Solution mySolution;
    std::vector<int> myVector = {-1, 0, 1, 2, -1, -4};
    std::vector< std::vector<int> > myAnswers = mySolution.threeSum(myVector);
    for(int i = 0; i < myAnswers.size(); ++i){
        for(int j = 0; j < myAnswers[i].size(); ++j){
            std::cout << myAnswers[i][j] << " ";
        }
        std::cout << "\n";
    }
    return 0;
}
    
