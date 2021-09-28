// Important visual:
//  
//                 x:        1 2 4 7 9 | 11 14 20 21
//             
//                 y:        3 5 6 8 | 12 15 18 19
//  
//                                     |
//                                     | 
//                                     v 
//  
// Combined Array:  1 2 3 4 5 6 7 8 9 | 11 12 14 15 18 19 20 21
// Gist: The goal is the find the correct parition in the arrays that allows us to immediately find the median. The
// numbers just around the partitions will be the numbers of interest. Finding the partition is done with binary search
// (although iteration may also work). Then from there getting the median will be algebriac.

class Solution {
     public static double findMedianSortedArrays(int[] a, int[] b){
         //if a length is greater than switch them so that input1 is smaller than b.
        if (a.length > b.length) {
            return findMedianSortedArrays(b, a);
        }
        int x = a.length;
        int y = b.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : a[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : b[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }
        return 0.0;

     }
 }


