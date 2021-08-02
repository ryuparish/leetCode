// We can either use a queue and get O(m+n) time complexity and O(m) space completxity
// Or we can do O(m*n) time complexity and O(1) space complexity,
// Or (from the discussions) we can go backwards and get O(m+n) time complexity and O(1) space complexity.
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int progressHead = (m + n) - 1;
        m--; n--;
        //int head1 = m-1, head2 = n-1, progressHead = (m + n) -1;
        while(m >= 0 && n >= 0){
            if(nums1[m] > nums2[n]){
                nums1[progressHead--] = nums1[m--];
            }
            else{nums1[progressHead--] = nums2[n--];}
        }
        // If nums2 was to run out first, then the entire nums1 array would already be sorted and there would only be comparisons
        // with nums1[progressHead] and nums1[head1] where head1 would be equal to progressHead.
        // There would only be (m + n - x - n) spaces remaining and the actions so far would have been: m` = (m - x) and
        // progressHead = (m + n) - (n + x) == m`.
        // 
        // Therefore, we only have to worry about head2 being looped after the loop above.
        while(n >= 0){
            nums1[progressHead--] = nums2[n--];
        }
    }
};
