/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Gist: Use dfs and keep track of the depth to multiply with.
// TC: O(n), SC: O(n) if call stack is considered, O(1) otherwise
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return returnSum(nestedList, 1);
    }
    
    private int returnSum(List<NestedInteger> nList, int depth){
        int sum = 0;
        for(NestedInteger item : nList){
            sum += item.isInteger() ? item.getInteger() * depth : returnSum(item.getList(), depth+1);
        }
        return sum;
    }
}
