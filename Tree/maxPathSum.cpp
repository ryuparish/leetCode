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
// IMPORTANT!!!!!!!
/* Misunderstood the question at first. You cannot have a "path" that splits into both ways*/
class Solution {
public:
    int findMaxPath(int* myAnswer, TreeNode* root){
        if(root != NULL){
            // The "adjacent" maxes.
            int leftMax = max(findMaxPath(myAnswer, root->left), 0);
            int rightMax = max(findMaxPath(myAnswer, root->right), 0);
            int returnVal = root->val;
            // Update highscore because using the current node as a connection is still a valid path
            myAnswer[0] = max(returnVal+leftMax+rightMax, myAnswer[0]);
            return root->val+max(leftMax, rightMax);
        }
        return INT_MIN;
    }
    int maxPathSum(TreeNode* root) {
        if(root->left == NULL && root->right == NULL){return root->val;}
        int myAnswer[] = {INT_MIN};
        findMaxPath(myAnswer, root);
        return myAnswer[0];
    }
};
