// DP 
// TC: O(2n) -> O(n) , SC: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        // Answer collects exclusive charges
        int[] answer = new int[length];
        answer[0] = 1;
        for(int i = 1; i < length; ++i){
            // From 1 (really 0) to length -1
            // Multiplying the answer[i-1] and the number behind
            answer[i] = nums[i-1] * answer[i-1];
        }
        int charge = 1;
        for(int i = length-2; i >= -1; --i){
            // From length -2 (really length-1) to 0
            // Multiplying the charge and the answer[i+1]
            answer[i+1] = charge * answer[i+1];
            charge *= nums[i+1];
        }
        return answer;
    }
}
