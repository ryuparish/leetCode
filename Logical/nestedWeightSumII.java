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

// This is non-optimal, but I like it and it is intuitive.
// TC: O(n), SC: O(n) if we include call stack O(1) otherwise`jk
class Solution {
    public int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        this.maxDepth = this.maxDepth(nestedList, 1);
        System.out.println(this.maxDepth);
        int sum = 0;
        return getSum(nestedList, 1);
    }
    
    private int getSum(List<NestedInteger> nList, int depth){
        int sum = 0;
        for(NestedInteger item : nList){
            sum += item.isInteger() ? item.getInteger() * ((this.maxDepth - depth) + 1): getSum(item.getList(), depth+1);
        }
        return sum;
    }
    
    private int maxDepth(List<NestedInteger> nList, int depth){
        int max = depth;
        for(NestedInteger item : nList){
            if(!item.isInteger()){
                max = Math.max(max, maxDepth(item.getList(), depth+1));
            }
        }
        return max;
    }
}
