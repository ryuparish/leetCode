// Major ass kicking by the mathematical relationships of binary search along with the mathematical process of Binary Search itself.
// What comes in handy in this solution is this:
// 1. Modulo operator.
// 2. Binary Search Twice (one to search for the smallest value and one to use for possibly finding the target)
class Solution {
    public int search(int[] nums, int target) {
        // First I need to search for k with Binary Search
        // The while loop will either move up lower boundary to a point where midValue is less than upperBoundaryValue, or move back upperBoundary
        // until either lowerBoundary is moved up again, or mid finds the rotation-1 position and pushes lowerBoundary onto the rotationIndex.
        // The reason this is valid is because Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        int lowerBound = 0, upperBound = nums.length-1, midIndex = 0, shiftedMid = 0;
        while(lowerBound < upperBound){
            midIndex= (lowerBound + upperBound) /2;
            // In the case we get lucky and find the index whilst searching for
            // the lowest value
            if(nums[midIndex] == target){
                return midIndex;
            }
            else if(nums[midIndex] > nums[upperBound]){
                lowerBound = midIndex + 1;
            }
            else{
                upperBound = midIndex;
            }
        }
        // The rotationIndex and k are not the same. The rotation index will tell us how much the list has been rotated.
        int rotationIndex = lowerBound;
        lowerBound = 0; upperBound = nums.length-1;
        // BEWARE OF EDGE CASES EXPLAINED BELOW WITH EXPLANATION
        // We can perform binary search regularly and just account for the rotation because although the lower and upper bound are not 
        // accurate, the place in which the search happens is accurate and the placement of the new bounds only affects the spot searched, albeit correctly.
        // If too high, the spot still moves down and vice versa, therefore the oscillation technique is STILL valid.
        
        // This is a good lesson on what binary search mathematically is performing.
        
        // RELATIONSHIP OF <=, < and -1,  +1.
        // We MUST use +1 for avoiding the "move lowerbound by 1 and loop forever" problem, and then -1 for the upperBoundary along with <= in the
        // case we have only a single number in the list (we must use <= because lowerBoundary == upperBoundary in the very beginning). 
        // The -1 to upperBoundary is to prevent the same infinite loop due to the <=. 
         
        while(lowerBound <= upperBound){
            midIndex = ((lowerBound + upperBound) /2);
            shiftedMid = (midIndex + rotationIndex) %nums.length;
            if(nums[shiftedMid] == target){
                return shiftedMid;
            }
            else if(nums[shiftedMid] < target){
                lowerBound = midIndex + 1;
            }
            // target is less than the lowerBound value but greater than the midIndex value
            else{
                upperBound = midIndex - 1;
            }
            
        }
        return -1;
    }
}
