class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
      int[] nodeColors = new int[n];
      boolean[][] graph = new boolean[n][n];
      
      // Create the edges of the graph
      for (int i = 0; i < dislikes.length; ++i) {
        int srcNode = dislikes[i][0] - 1;
        int dstNode = dislikes[i][1] - 1;
        graph[srcNode][dstNode] = true;
        graph[dstNode][srcNode] = true;
      }
      
      // Coloring and checking if the coloring is possible for each node
      for (int i = 0; i < n; ++i) {
        // Coloring the current node with 1 if it is not colored already
        // Note: if the node is not 0 (already colored) it has been checked.
        if (nodeColors[i] == 0 && !isColorable(graph, nodeColors, i, 1)) {
          return false; // Not possible to color
        }
      }
      
      return true;
    }
  
    // Colors all nodes with any-depth connection to this node if possible
    // without two of the same colored-nodes connected to each other.
    private boolean isColorable(boolean[][] graph, int[] nodeColors, int nodeNum, int color){
      nodeColors[nodeNum] = color;
      for (int i = 0; i < graph.length; ++i) {
        if (graph[nodeNum][i]) {
          // Is the color the same?
          if (nodeColors[i] == color) {
            return false;
          }
          // Not the same color. Is it possible to color with the opposite color?
          if (nodeColors[i] == 0 && !isColorable(graph, nodeColors, i, -color)) {
            return false;
          }
        }
      }
      return true;
    }
}
