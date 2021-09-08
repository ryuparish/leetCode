class Solution {
     public static double findMedianSortedArrays(int[] a, int[] b){
         int total_length = a.length + b.length;
         // The plus one here is for the purpose of keeping either the majority or equal parts on the left side of the partition. Adding 1 will ensure safety in both even and odd cases.
         // For example, if the total was even, the number would gain only .5, which will not change the half. But on the chance that it is odd, it will ensure that it is the majority rather than
         // less than the right side. (from 15/2 = 7.5 -> 7[less than], to 15+1/2 = 8[majority])
         int half = (total_length + 1) / 2;
 
         // We set a to be the shorter one because we want to minimized the area we will be 
         // conducting the binary search 
         if(a.length > b.length){
             int[] holder = b;
             b = a;
             a = holder;
         }
 
         int i, j, l = 0, r = a.length;
         double Aleft, Aright, Bleft, Bright;
         while(true){
             i = (l + r) / 2;
             j = (half) - i; // j will contain the remaining of partition for the second list (list a)
 
             // When we cross the lower boundary, we set to negative infinity because we were looking for a smaller value and negative infinity will satisfy that constraint.
             // When we cross the upper boudnary, we set to infinity because we were looking for a larger value and infinity will satisfy that constraint.
             Aleft = i == 0 ? -1 * Double.POSITIVE_INFINITY : a[i-1];
             Aright = (i) < a.length ? a[i] : Double.POSITIVE_INFINITY;
             Bleft = j == 0 ? -1 * Double.POSITIVE_INFINITY : b[j - 1];
             Bright = (j) < b.length ? b[j] : Double.POSITIVE_INFINITY;
 
             // If the partition is correct 
             if(Aleft <= Bright && Bleft <= Aright){
                 // if odd 
                 if((total_length % 2) != 0){
                     return Math.max(Aleft, Bleft);
                 }
                 // if even
                 return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
             }
 
             else if(Aleft > Bright){
                 r = i - 1;
             }
             else{ 
                 l = i + 1;
             }
         }
     }

     public static void main(String[] args){
         int[] a = {2, 3};
         int[] b = {};
         double median = findMedianSortedArrays(a, b);
         System.out.println(median);
         return;
     }
 }

