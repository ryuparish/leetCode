class Solution {
    public int removeElement(int[] nums, int val) {
        int dupeCap = nums.length - 1, k = 0, swap;
        if(nums == null){
            return k;
        }
        while(dupeCap >= 0 && nums[dupeCap] == val){
            --dupeCap;
        }
        if(dupeCap < 0){return k;}
        for(int i = 0; i <= dupeCap; ++i){
            if(nums[i] == val){
                swap = nums[dupeCap];
                nums[dupeCap] = val;
                nums[i] = swap;
                --dupeCap;
                --i;
                continue;
            }
            ++k;
        }
        return k;
    }
}
