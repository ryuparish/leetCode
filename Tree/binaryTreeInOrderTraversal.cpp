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
    vector<int> inorderTraversal(TreeNode* root) {
        std::vector<int> answer;
        std::stack<TreeNode*> S;
        while(root != NULL || !S.empty()){
            if(root != NULL){
                S.push(root);
                root = root->left;
            }
            else{
                root = S.top();
                S.pop();
                answer.push_back(root->val);
                root = root->right;
            }
        }
        return answer;
    }
};
