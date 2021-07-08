class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // The median index is the sum of each list's lengths divided
        // by 2.
        int medianIndex = ((nums1.length + nums2.length) - 1)/2;

        boolean isOdd = false;
        // If the sum is odd
        if((nums1.length + nums2.length) % 2 != 0){
            isOdd = true;
        }

        // Base Case where they can be appended at their ends
        // This can STILL BE EVEN OR ODD AND IT WILL BE DIFFERENT AT EITHER CONDITION
        // There is also the case where the length is even and the median is split from the end of the first list to the end of the second list 
        if(nums1.length > 0 && nums2.length > 0){
            if(nums1[nums1.length-1] <= nums2[0]){
                if(isOdd){
                    if(medianIndex < nums1.length){
                        return nums1[medianIndex];
                    }
                    else{
                        return nums2[medianIndex - nums1.length];
                    }
                }
                else{
                    if(medianIndex < nums1.length){
                        // Median is split between the lists
                        if(medianIndex == nums1.length -1){
                            return (nums1[medianIndex] + nums2[0])/ 2.0;
                        }
                        return (nums1[medianIndex] + nums1[medianIndex + 1]) / 2.0;
                    }
                    else{
                        return (nums2[medianIndex - nums1.length] + nums2[(medianIndex - nums1.length) + 1])/2.0;
                    }
                }
            }
            else if(nums2[nums2.length-1] <= nums1[0]){
                if(isOdd){
                    if(medianIndex < nums2.length){
                        return nums2[medianIndex];
                    }
                    else{
                        return nums1[medianIndex - nums2.length];
                    }
                }
                else{
                    if(medianIndex < nums2.length){
                        // Median is split between the lists
                        if(medianIndex == nums2.length -1){
                            return (nums2[medianIndex] + nums1[0])/ 2.0;
                        }
                        return (nums2[medianIndex] + nums2[medianIndex + 1]) / 2.0;
                    }
                    else{
                        return (nums1[medianIndex - nums2.length] + nums1[(medianIndex - nums2.length) + 1])/2.0;
                    }
                }
            }
        }

        // Base Case where one is equal to length zero
        else if(nums1.length == 0 || nums2.length == 0){
            // If nums1 has length
            if(nums1.length != 0){
                return nums1[medianIndex];
            }
            // If nums2 has length
            else if (nums2.length != 0){
                return nums2[medianIndex];
            }
            // If both are empty
            return 0;
        }

        // Both lengths are of length one
        else if(nums1.length == 1 && nums2.length == 1){
            return (nums1[0] + nums2[0]) / 2;
        }
        
        // The ends overlap and we need to algorithmically solve
         
        // Getting the indexes of the medians for both of the num lists
        int nums1MedianIndex = (nums1.length-1)/2;
        int nums2MedianIndex = (nums2.length-1)/2;

        // Arbitarily choosing nums1 to be the first list be check
        //
        // Edge Cases:
        // 1. The spot after remaining from medianIndex - numslistMedianIndex  is
        // greater than the length of the list(seg fault into other page).
        // A: This would never happen because (a+b)/2 = (a/2) + (b/2), meaning if we take away a or b's half, the remaining half will always be half of the other length.
        // (ie. (a/2) + (b/2) - (a/2) = b/2)
        //
        // 2. (impossible)The case that both the numbers violate the spot after the remainder in the other list.
        // A: If one the medians is greater than the spot after the remainder in the other list, the number before that spot(ie.
        // the median of the other list), then the median of the other list CANNOT possibly be larger than the median first mentioned,
        // since that one is greater than a value greater than the median on the other list.
        //
        // 3. Segfaulting on the first list due to nums1MedianIndex + 1 being larger than nums1.length
        // A: This would only happend in the case where the size of nums1 is 0 or 1. In all other cases, there will always be
        // a value after n/2. ( floor((n-1)/2) + 1 < n for all integers n > 1 )
        //
        // 4. Segfaulting at either ends of either list while searching for compatible numbers in either loop
        // A: Possible.
        //
        // 5. Segfaulting at the same time for both lists
        // A: This should never happen because then that would mean they could have been appended together and would have been caught beforehand

        // Subtracting the number of spots we have traveled from the medianIndex
        int remainingPartition = (medianIndex - (nums1MedianIndex + 1));
        boolean nums1Fault = false;
        boolean nums2Fault = false;
        boolean bothLists = true;
        boolean rotated = false;

        // If the value at the remaining partition is greater than
        // the median of nums1 + 1.
        for(int i = 0; i < 2; ++i){
            if(nums2[remainingPartition] > nums1[nums1MedianIndex + 1]){
                // Moving the top list back and the bottom list forward until the condition is met or one of the them goes out of bounds
                // Clockwise rotation
                // Nums1MedianIndex could pass the length or remainingPartition could go under 0 in nums2
                while(true){
                    if(nums2[remainingPartition] <= nums1[nums1MedianIndex]){
                        rotated = true;
                        break;
                    }
                    nums1MedianIndex++;
                    remainingPartition--;
                    // Setting the remainingPartition to negInf if it bottoms out
                    if(remainingPartition < 0){
                        nums2Fault = true;
                        bothLists = false;
                        break;
                    }
                    // Setting the nums1MedianIndex to Inf if it goes over the length
                    else if(nums1MedianIndex > nums1.length){
                        nums1Fault = true;
                        bothLists = false;
                        break;
                    }
                }

                // Check for both lists and if one ran out or if there was a rotation done then conclude, else check the other side for a violation.
                if(!bothLists || rotated){
                    // nums1MedianIndex faulted
                    if(nums1Fault){
                        if(isOdd){
                            return nums2[remainingPartition];
                        }
                        else{
                            return (nums2[remainingPartition] + nums2[remainingPartition + 1])/2.0;
                        }
                    }
                    // remainginPartition in nums2 faulted
                    else if(nums2Fault){
                        if(isOdd){
                            return nums1[nums1MedianIndex];
                        }
                        else{
                            return (nums1[nums1MedianIndex] + nums1[nums1MedianIndex + 1])/2.0;
                        }
                    }
                    // Neither faulted and we arrived a compatible solution
                    else{
                        if(isOdd){
                            return Math.min(nums1[nums1MedianIndex + 1], nums2[remainingPartition+1]);
                        }
                        else{
                            return (Math.max(nums1[nums1MedianIndex], nums2[remainingPartition]) + Math.min(nums1[nums1MedianIndex + 1], nums2[remainingPartition+1]))/2.0; 
                        }
                    }
                }
            }
            // If it reaches here, then the values were on a good partition from the start and now we switch and check the other side
            int[] holder = nums1;
            int medianHolder = nums1MedianIndex; 
            nums1 = nums2;
            nums2 = holder;
            nums1MedianIndex = remainingPartition;
            remainingPartition = medianHolder; 
        }

        // If it made it here, it was a perfect partition to begin with in both ways 
        if(isOdd){
            return Math.max(nums1[nums1MedianIndex + 1], nums2[remainingPartition + 1]);
        }
        else{
            return (Math.max(nums1[nums1MedianIndex], nums2[remainingPartition]) + Math.min(nums1[nums1MedianIndex + 1], nums2[remainingPartition + 1])) / 2.0;
        }
    }
}

