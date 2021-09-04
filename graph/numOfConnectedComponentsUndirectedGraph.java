// This problem involved an adj graph then a dfs search along with some dynammic programming.
class Solution {
    private void dfs(int currNode, boolean[] visited, List<Integer>[] adj){
        visited[currNode] = true; // Visiting the current node
        for(int i = 0; i < adj[currNode].size(); ++i){
            if(!visited[adj[currNode].get(i)]){
                dfs(adj[currNode].get(i), visited, adj);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        // This definition can allow us to predefine the arraylist size
        // Array of ArrayLists
        List<Integer>[] adj = new ArrayList[n];
        boolean[] visited = new boolean[n];
        // Adding all of the arrays to the array of arraylists
        while(n-- > 0) adj[n] = new ArrayList<Integer>();
        // Add all of the adjacent nodes together
        // We do both ways because this is not a directed graph, and when one node is connected to 
        // the other,  they can both travel to each other. There is no relationship hierarchy.
        for(int i = 0; i < edges.length; ++i){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        // Looping through the adj list and looking for all non-visited starting points to count
        // groups of nodes
        int groups = 0;
        for(int i = 0; i < visited.length; ++i){
            if(!visited[i]){
                dfs(i, visited, adj);
                groups++;
            }
        }
        return groups;
    }
}
