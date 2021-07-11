// Pseudocode
//class Solution:
//    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
//        A, B = nums1, nums2
//        total = len(nums1) + len(nums2)
//        half = total // 2
//        
//        if len(B) < len(A):
//            A, B = B, A
//        
//        l, r = 0, len(A) - 1
//        while True:
//            i = (l + r) // 2 // A
//            j = half - i - 2 // B
//        
//            Aleft = A[i] if i >= 0 else float("-infinity")
//            Aright = A[i + 1] if (i + 1) < len(A) else float("infinity")
//            Bleft = B[j] if j >= 0 else float("-infinity")
//            Bright = B[j + 1] if (j + 1) < len(B) else float("infinity")
//        
//            // partition is correct
//            if Aleft <= Bright and Bleft <= Aright:
//                // odd
//                if total % 2:
//                    return min(Aright, Bright)
//                // even
//                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
//            elif Aleft > Bright:
//                r = i - 1
//            else:
//                l = i + 1

// In essence, we are using binary search in list a to find
// the partition that satisfies the constraints of either partition in either list
// being less than the value right in front of the other list's partition.
class Solution {
    public static double findMedianSortedArrays(int[] a, int[] b){
        int total_length = a.length + b.length;
        int half = total_length / 2;

        // We set a to be the shorter one because 
        if(a.length > b.length){
            int[] holder = b;
            b = a;
            a = holder;
        }

        int i, j, l = 0, r = a.length - 1;
        double Aleft, Aright, Bleft, Bright;
        while(true){
            i = (l + r) / 2;
            j = (half - 1) - (i + 1);

            Aleft = i >= 0 ? a[i] : Double.POSITIVE_INFINITY;
            Aright = (i + 1) < a.length ? a[i + 1] : -1 * Double.POSITIVE_INFINITY;
            Bleft = j >= 0 ? b[j] : Double.POSITIVE_INFINITY;
            Bright = (j + 1) < b.length ? b[j + 1] : -1 * Double.POSITIVE_INFINITY;

            // If the partition is correct
            if(Aleft <= Bright && Bleft <= Aright){
                // if odd
                if((total_length % 2) != 0){
                    return Math.min(Aright, Bright);
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
        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8};
        double answer = findMedianSortedArrays(array1, array2);
        System.out.println(answer);
    }
}
