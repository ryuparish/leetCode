class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        if(nums.length < 1){
            return answer;
        }
        // Binary search to find the number
        boolean targetFound = false;
        int lowerIdx = 0, upperIdx = nums.length -1, midIdx = 0;
        while(lowerIdx <= upperIdx){
            midIdx = (lowerIdx + upperIdx) / 2;
            if(nums[midIdx] == target){
                targetFound = true;
                break;
            }
            else if(nums[midIdx] > target){
                upperIdx = midIdx-1;
            }
            else{
                // Plus one for the "+1 and round down to the same number" scenario
                lowerIdx = midIdx+1;
            }
        }
        // Expanding window to find the range of the number
        if(targetFound){
            int leftHead = midIdx, rightHead = midIdx;
            boolean leftFinish = false, rightFinish = false;
            while(!leftFinish || !rightFinish){
                if(rightHead < nums.length && nums[rightHead] == target){
                    answer[1] = rightHead++;
                }
                else{rightFinish = true;}
                if(leftHead >= 0 && nums[leftHead] == target){
                    answer[0] = leftHead--;
                }
                else{leftFinish = true;}
            }
        }
        return answer;
    }
}
