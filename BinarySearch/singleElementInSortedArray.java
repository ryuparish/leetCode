// Gist: The key to this one is to know that the pairless number is the first pairless number. We hardcode the mid to be 
// even, so mid will have particular patterns: If mid is to the left of the same number, the even list
// is to the left and therefore the answer is to the right. If mid is not to the left of the same number, the even list
// is on the right and then the answer is on the left and so on. Once hi == lo, we have found the answer.

// And finally, Diagram:

    // Regularly, when you split a list with no unpaired
        // [Even indices are always the "first" of the pair]
        // Indices:
        // 0  1  2  3  4  5  6  7
        // 0, 0, 1, 1, 2, 2, 3, 3
        // |-all-evens-are-"first"->

    // When there is an odd among them
        // [Even indices are always the "second" of the pair]
        // Indices:
        // 0  1  2  3  4  5  6  7
        // 0, 0, 1, 2, 2, 3, 3, 4
        // <-first--|-all-evens-are-"second"->

    // Scenarios (mid will always be even because we hard-code it)

        // "second" [Go left]
        //             v ((7 - 0) / 2)
        // 0, 0, 1, 2, 2, 3, 3, 4, 4

        // "only" [Go left]
        //             v ((7 - 0) / 2)
        // 0, 0, 2, 2, 1, 3, 3, 4, 4

        // "first" [Go right]
        //             v ((7 - 0) / 2)
        // 0, 0, 2, 2, 3, 3, 4, 4, 1

// TC: O(logn) SC: O(1)
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length-1, mid;
        while(l < r){
            mid = (l + r) / 2;
            if(mid % 2 == 1){mid--;}
            // This even is "first"
            if(nums[mid] == nums[mid+1]){l = mid + 2;}
            // This even is "second" or "only"
            else{r = mid;}
        }
        return nums[l];
    }
}
