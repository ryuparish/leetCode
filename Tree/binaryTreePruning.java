class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root.left != null && pruneTree(root.left) == null){
            root.left = null;
        }
        if(root.right != null && pruneTree(root.right) == null){
            root.right = null;
        }
        if(root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;
    }
}
// Less understandable 3 line solution 
//class Solution {
//    public TreeNode pruneTree(TreeNode root) {
//        if(root.left != null && pruneTree(root.left) == null)root.left = null;
//        if(root.right != null && pruneTree(root.right) == null)root.right = null;
//        if(root.val == 0 && root.left == null && root.right == null)return null;
//        return root;
//    }
//}
