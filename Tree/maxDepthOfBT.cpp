class Solution {
public:
    int findDepth(TreeNode* currNode, int maxDepth){
        if(currNode == NULL){
            return maxDepth;
        }
        return max(findDepth(currNode->left, 1 + maxDepth), findDepth(currNode->right, 1 + maxDepth));
    }
    int maxDepth(TreeNode* root) {
        if(root == NULL){return 0;}
        return max(findDepth(root->left, 1), findDepth(root->right, 1));
    }
};
