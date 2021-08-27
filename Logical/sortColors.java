class Solution {
    // Bubble Sort 
    // TC: O(n^2) , SC: O(1)
    //public void sortColors(int[] nums) {
    //    int tmp = 0;
    //    for(int i = 0; i < nums.length; ++i){
    //        for(int j = 0; j < nums.length-(i+1); ++j){
    //            if(nums[j] > nums[j+1]){
    //                tmp = nums[j+1];
    //                nums[j+1] = nums[j];
    //                nums[j] = tmp;
    //            }
    //        }
    //    }
    //}
    
    // Count and place method
    // TC: O(2n), SC: O(n)
    public void sortColors(int[] nums){
        if(nums.length == 1){return;}
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i){
            if(myMap.containsKey(nums[i])){myMap.put(nums[i], myMap.get(nums[i])+1);}
            else{myMap.put(nums[i], 1);}
        }
        int currNum = 0, currStart = 0;
        for(int i = 0; i < 3; ++i){
            if(myMap.containsKey(i)){
                for(int j = currStart; j < currStart + myMap.get(i); ++j){
                    nums[j] = i;
                }
                currStart += myMap.get(i);
            }
        }
    }
    
    // Most optimal method (two pointers)
	// TC: too lazy SC: too lazy
    // Swap has to be replaced with and actual swap function or process
    //public void sortColors(int A[], int n) {
    //    int second=n-1, zero=0;
    //    for (int i=0; i<=second; i++) {
    //        while(A[i]==2 && i<second){swap(A[i], A[second--]);}
    //        while(A[i]==0 && i>zero){swap(A[i], A[zero++]);}
    //    }
    //}
}
