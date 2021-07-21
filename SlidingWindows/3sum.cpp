#include <vector>
#include <algorithm>
class Solution{
public:
    std::vector< std::vector<int> > threeSum(std::vector<int>& nums){
        std::vector< std::vector<int> > answers;
        if(nums.size() <= 2){return answers;}
        // With this method, duplicates are of no worry because we always explicitly skip over redundant/duplicate searches
        // Sort the list
        std::sort (nums.begin(), nums.end());
        // Make the pointers
        int frontHead, backHead;
        for(int i = 0; i < nums.size(); ++i){
            frontHead = i + 1;
            backHead = nums.size() - 1;
            
            // For running over redundant searches
            if(i > 0 && nums[i] == num[i-1]){continue;}
            
            int sum;
            while(backHead > frontHead){
                sum = nums[i] + nums[frontHead] + nums[backHead];
                if(sum == 0){
                    std::vector<int> newVector = {nums[i], nums[frontHead], nums[backHead]};
                    answer.push_back(newVector);
                    ++frontHead;
                    --backHead;
                    while(backHead > frontHead && nums[frontHead] == nums[frontHead - 1]){
                        ++frontHead;
                    }
                    while(backHead > frontHead && nums[backHead] == nums[backHead +1]){
                        --backHead;
                    }
                }
                else if(sum > 0){
                    --backHead;
                }
                else{++frontHead};
            }
        }
        return answers;
    }
};
