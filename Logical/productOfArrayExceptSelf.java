// TC: O(n), SC: O(n)
// Use prefix and postfix products in two different loops to place prefix product (1st loop), then multiply by postfix product (2nd loop)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int frontPointer = 0, backPointer = nums.length-1;
        int frontProduct = 1, backProduct = 1;
        int[] res = new int[nums.length];
        
        // Place the prefix product in the array
        for(int i = 0; i < nums.length; ++i){
            res[i] = frontProduct;
            frontProduct *= nums[i];
        }

        // Multiply the prefix product in the array with postfix product
        for(int i = nums.length-1; i >= 0; --i){
            res[i] *= backProduct;
            backProduct *= nums[i];
        }
        return res;
    }
}
