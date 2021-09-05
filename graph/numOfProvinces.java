// dfs for each group with dp, visited.
// TC: O(n), SC(n)
class Solution {
    public void dfs(boolean[] visited, int[][] isConnected, int currNode){
        visited[currNode] = true;
        for(int i = 0; i < isConnected.length; ++i){
            if(isConnected[currNode][i] == 1 && !visited[i]){
                dfs(visited, isConnected, i);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int groups = 0;
        // Loop through to find the 
        for(int i = 0; i < visited.length; ++i){
            if(!visited[i]){dfs(visited, isConnected, i); groups++;}
        }
        return groups;
    }
}
