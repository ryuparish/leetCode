#include <iostream>
#include <vector>
class Solution{
public:
    int maxSubArray(std::vector<int>& nums){
        int maxSum = 0;
        for(int i = 0; i < nums.size(); ++i){
            if(maxSum + nums[i] > nums[i]){
                maxSum += nums[i];
                std::cout << "new maxSum: " << maxSum << "\n";
            }
            else{maxSum = nums[i];}
            std::cout << "new maxSum: " << maxSum << "\n";
        }
        return maxSum;
    }
};

int main(){
    Solution mySolution = Solution();
    std::vector<int> myNums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int maxSum = mySolution.maxSubArray(myNums);
    std::cout << maxSum << "\n";
    return 0;
}
