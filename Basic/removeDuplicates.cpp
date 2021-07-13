#include <iostream>
#include <vector>
class Solution {
public:
    int removeDuplicates(std::vector<int>& nums) {
        if(nums.size() < 1){
            return 0;
        }
        // There is at least one unique element in a vector of size one 
        int k=1, orig=nums[0], dupechecker;
        for(dupechecker = 0; dupechecker < nums.size(); ++dupechecker){
            if(nums[dupechecker] > orig){
                nums[k] = nums[dupechecker];
                ++k;
                orig = nums[dupechecker];
            }
        }
        return k;
    }
};

int main(){
    Solution mySolution;
    std::vector<int> nums = {0,0,1,1,1,2,2,3,3,4};
    int k = mySolution.removeDuplicates(nums);
    std::cout << "Here is the value of k: " << k << "\n";
    std::cout << "Here is the vector:\n";
    for(int i = 0; i < nums.size(); ++i){
        std::cout << nums[i] << " ";
    }
    std::cout << "\n";
    return 0;
}
