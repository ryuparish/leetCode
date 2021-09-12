/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

// DFS solution
// TC: O(n), SC: O(1)
//class Solution {
//    Node answer;
//    private boolean findLCA(Node root, int pval, int qval){
//        // Precautionary (I don't think this will ever trigger)
//        if(root == null){return false;}
//        int left = 0, right = 0, mid = 0;
//        if(root.val == pval || root.val == qval){mid = 1;}
//        if(findLCA(root.left, pval, qval)){left = 1;}
//        if(findLCA(root.right, pval, qval)){right = 1;}
//        if(left + right + mid > 1){this.answer = root;}
//        
//        return left+right+mid >= 1;
//    }
//    public Node lowestCommonAncestor(Node p, Node q) {
//        Node root = findParent(q);
//        findLCA(root, p.val, q.val);
//        return this.answer;
//    }
//    private Node findParent(Node currNode){
//        if(currNode.parent == null){return currNode;}
//        return findParent(currNode.parent);
//    }
//}
// Using a HashSet
// TC: O(n) SC: O(n)
//class Solution {
//    Set<Node> nodeSet;
//    private void mapVein(Node root){
//        this.nodeSet.add(root);
//        if(root.parent == null){return;}
//        mapVein(root.parent);
//    }
//    private Node searchVein(Node root){
//        if(this.nodeSet.contains(root)){return root;}
//        return searchVein(root.parent);
//    }
//    public Node lowestCommonAncestor(Node p, Node q){
//        this.nodeSet = new HashSet<Node>();
//        mapVein(p);
//        return searchVein(q);
//    }
//}

// Using the "linked list intersection flip" technique
// TC: O(n), SC: O(1)
class Solution{
    public Node lowestCommonAncestor(Node p, Node q){
        Node a = p;
        Node b = q;
        // After the switch, the alternate head will be the same distance from the intersection
        while(a != b){
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
