// TC: O(nlogn), SC: O(1) (Compared to hashmap -> TC: O(n) , SC: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int currInt = nums[0];
        for(int i = 1; i < nums.length; ++i){
            if(currInt == nums[i]){return true;}
            else{currInt = nums[i];}
        }
        return false;
    }
}
