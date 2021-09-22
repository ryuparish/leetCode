// QuickSelect
// If you think about it the pivot of recursive call for quicksort is in the correct position
// if the list were to be sorted entirely. All values left would be less than it and all values
// to right of it would be greater than it, meaning it is in it's sorted position. We just need
// k to be the pivot in this case.
class Solution {
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
        return;
    }
    
    public int findKthLargest(int[] nums, int k) {
		// The kth LARGEST, so length - k (k is guaranteed to be at least 1)
        quickSelect(nums, 0, nums.length-1, nums.length-k);
        return nums[nums.length - (k)];
    }
    
    private void quickSelect(int[] nums, int start, int end, int target){
        
        // Conditional is needed for recurrence to work
        // This must be < rather than <= because if they are equal 
        if(start < end){
            int partition_ = partition(nums, start, end);
            if(partition_ == target){return;}
			
			// We want to move in the direction that contains the target index
            else if(partition_ > target){
                quickSelect(nums, start, partition_-1, target);
            }
            else{
                quickSelect(nums, partition_+1, end, target);
            }
        }
    }
    
    private int partition(int[] nums, int start, int end){
        int pindex = start + new Random().nextInt(end - start);
        int pVal = nums[pindex];
        int swapper = start;

		// Swap to safekeep pivot value
        swap(nums, pindex, end);
        for(int i = start; i <= end; ++i){
            if(nums[i] < pVal){
                swap(nums, swapper, i);
                swapper++;
            }
        }

		// Swap back to rightful sorted spot
        swap(nums, end, swapper);
        return swapper;
    }
}
