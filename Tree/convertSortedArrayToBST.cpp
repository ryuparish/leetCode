class Solution {
public:
    TreeNode* recurseTree(vector<int>& nums, int left, int right){
        if(right < left){
            return NULL;
        }
        int mid = left + (right - left)/2;
        TreeNode* newNode = new TreeNode(nums[mid]);
        // Merge call to balance the tree (every left call has it's own right call reserved, which in this case will also go on to
        // be right child)
        newNode->left = recurseTree(nums, left, mid-1);
        newNode->right = recurseTree(nums, mid+1, right);
        return newNode;
    }
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        if(nums.size() < 2){
            return new TreeNode(nums[0]);
        }
        return recurseTree(nums, 0, nums.size() - 1);
    }
};
