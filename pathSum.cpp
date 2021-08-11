/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool hasPathSum2(TreeNode* root, int targetSum, int currSum) {
        if(root == NULL)
            return false;
        
        currSum = currSum + root->val;
        
        if(currSum == targetSum && (root->left == NULL && root->right == NULL)){
            return true;
        }
        
        return hasPathSum2(root->left, targetSum, currSum) || hasPathSum2(root->right, targetSum, currSum);
    }
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(root == NULL){
            return false;
        }
        return hasPathSum2(root, targetSum, 0);
    }
};
