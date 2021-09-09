/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Gist: Recurse for every open bracket. And quit if at the end of the string or at a closing bracket.
// IMPORTANT ORDERING: End of String check, Number Handling, Create Node,
//      Recurse left child, Recurse right Child.
class Solution {
    private int idx = 0;
    
    public TreeNode str2tree(String s) {
        return construct(s);
    }
    
    private TreeNode construct(String s) {
        if(idx >= s.length()){return null;}
        int currNum = 0;
        int sign = 1;
        // Number handling
        // Handling negative value
        if(s.charAt(idx) == '-'){
            sign = -1;
            idx++;
        }
        // Sticking numbers
        while(idx < s.length() && isDigit(s.charAt(idx))){
            currNum = currNum * 10 + toDigit(s.charAt(idx++));
        }
        currNum *= sign;
        TreeNode root = new TreeNode(currNum);
        
        // Recursing or cancelling if at the end or closing bracket
        // Left child
        if(idx < s.length() && s.charAt(idx) == '('){
            idx++;
            root.left = construct(s);
        }
        // Idx will be changed by this point
        // Right child
        if(idx < s.length() && s.charAt(idx) == '('){
            idx++;
            root.right = construct(s);
        }
        idx++;
        return root;
    }
    
    // Custom isDigit and toDigit functions
    private boolean isDigit(char c) {
        return c != '(' && c != ')';
    }
    
    private int toDigit(char c) {
        return c - '0';
    }
}
