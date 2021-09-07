// TC: O(NlogN), SC: O(1)
//class Solution {
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
//}

// QuickSelect
// If you think about it the pivot of recursive call for quicksort is in the correct position
// if the list were to be sorted entirely. All values left would be less than it and all values
// to right of it would be greater than it, meaning it is in it's sorted position. We just need
// k to be the pivot in this case.
class Solution {
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length-1, nums.length - k);
        for(int i = 0; i < nums.length; ++i){
            System.out.print(nums[i]);
        }
        System.out.println("");
        return nums[nums.length-k];
    }
    
    private void quickSelect(int[] nums, int start, int end, int k){
        if(start < end){
            int pindex = partition(nums, start, end);
            if(pindex == k){return;}
            if(pindex > k){
                quickSelect(nums, start, pindex-1, k);
            }
            else{quickSelect(nums, pindex+1, end, k);}
        }
    }
    
    private int partition(int[] nums, int start, int end){
        int pindex = start + new Random().nextInt(end - start);
        int pindexVal = nums[pindex];
        int swapperIdx = start;
        // Crucial step for a case like this:
        //      6,7,8,4,1,2,3,2,1
        //            ^
        //          pindex(this index will be overwritten and the final swapperIdx will not
        //          contain the pindexVal)
        swap(nums, end, pindex);
        for(int i = start; i <= end; ++i){
            // since this will activate and possibly swap start with start,
            // it is guaranteed that the value pindex is on will be larger than pindexVal
            // or on the same index as i.
            if(nums[i] < pindexVal){
                swap(nums, swapperIdx, i);
                swapperIdx = swapperIdx+1;
            }
        }
        swap(nums, swapperIdx, end);
        return swapperIdx;
    }
}
