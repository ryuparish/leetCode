class Solution{
    public int searchInsert(int[] nums, int target){
        int lowerBound = 0, upperBound = nums.length-1;
        int mid = 0;
        while(lowerBound <= upperBound){
            mid = (lowerBound + upperBound) / 2;
            if(nums[mid] > target){
                upperBound = mid - 1;
            }
            else if(nums[mid] < target){
                lowerBound = mid + 1;
            }
            else{return mid;}
        }
        // Valid index was not found
        if(nums[mid] > target){return mid;}
        else{return mid+1;}
    }
    //public static void main(String[] args){
    //    //int[] nums = {1, 3, 5, 7};
    //    //int[] nums = {-1, -3, -5, -7};
    //    //int[] nums = {1, 6, 7, 8};
    //    //int[] nums = {1, 3, 5, 6};
    //    //int[] nums = {1};
    //    //int[] nums = {1, 2, 3, 4, 5, 10};
    //    //int[] nums = {1, 3};
    //    //int target = 4;
    //    //int target = 7;
    //    //int target = 1;
    //    //int target = 2;
    //    //int target = 0;
    //    Solution mySolution = new Solution();
    //    System.out.println("answer: " + mySolution.searchInsert(nums,target));
    //}
}
