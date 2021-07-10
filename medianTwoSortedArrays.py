# Pseudocode
class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = total // 2
        
        if len(B) < len(A):
            A, B = B, A
        
        print("Half is:",half)
        print("This was chosen as list A:", A)
        l, r = 0, len(A) - 1
        while True:
            print("l is now: ", l, " r is now: ", r)
            i = (l + r) // 2 # A
            # We need to add one to the i value because we are substracting the number of spaces taken up rather than the index
            # and for the half value we need to do the inverse because we want the index value of half rather than the size of half the combined list
            j = (half - 1) - (i + 1) # B
            print("i is now: ", i, "j  is now: ", j)
        
            Aleft = A[i] if i >= 0 else float("-infinity")
            Aright = A[i + 1] if (i + 1) < len(A) else float("infinity")
            Bleft = B[j] if j >= 0 else float("-infinity")
            Bright = B[j + 1] if (j + 1) < len(B) else float("infinity")
        
            # partition is correct
            if Aleft <= Bright and Bleft <= Aright:
                # odd
                if total % 2:
                    return min(Aright, Bright)
                # even
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2
            elif Aleft > Bright:
                print("Changing the value of r: ", r, " into this: ", i - 1)
                r = i - 1
            else:
                print("Changing the value of l: ", l, " into this: ", i + 1)
                l = i + 1

def main():
    mySolution = Solution()
    listOne = [2, 4 , 6, 8, 10, 12, 14]
    listTwo = [1, 3, 5, 7, 9, 11, 13]
    myAnswer = mySolution.findMedianSortedArrays(listOne, listTwo)
    print(myAnswer)
    return 0;
main()
