class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int startHead = 0, endHead = numbers.size() - 1;
        std::vector<int> answer;
        while(startHead < endHead){
            if(numbers[startHead] + numbers[endHead] > target){
                endHead--;
            }
            else if(numbers[startHead] + numbers[endHead] < target){
                startHead++;
            }
            else{
                answer.push_back(++startHead);
                answer.push_back(++endHead);
                return answer;
            }
        }
        return answer;
    }
};
