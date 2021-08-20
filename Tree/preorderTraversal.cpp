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
    void traverse(TreeNode* root, std::vector<int>& answer){
        if(root != NULL){
            answer.push_back(root->val);
            traverse(root->left, answer);
            traverse(root->right, answer);
            return;
        }
    }
    vector<int> preorderTraversal(TreeNode* root) {
        std::vector<int> answer;
        traverse(root, answer);
        return answer;
    }
};
