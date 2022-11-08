// Write your code here
 public void main(String[] args){
      int[][] graph = new int[n][n];
      // Add the edges to the graph
      for (List<Integer> edge : edges) {
        graph[edge.get(0)-1][edge.get(1)-1] = 1;
        graph[edge.get(1)-1][edge.get(0)-1] = 1;
      }
      int currDepth = 0;
      int numFound = 0;
      
      Integer[] nodeDepths = new Integer[n];
      Arrays.fill(nodeDepths, -1);
      Queue<Integer> myQueue = new LinkedList<>();
      myQueue.add(s);
      
      while(!myQueue.isEmpty()) {
        // Go to every node that is listed and if there is an
        // edge we set it's respective depth to depth+1
        int currNode = myQueue.poll();
        for (int i = 0; i < n && numFound < n-1; ++i){
          if (graph[currNode][i] == 1 && nodeDepths[i] == -1) {
            myQueue.add(i);
            nodeDepths[i] = currDepth+6;
            numFound++;
          }
        }
        currDepth += 6;
      }
      List<Integer> res = new ArrayList<Integer>();
      for (int i = 0; i < nodeDepths.length; ++i) {
        if (i == s){
          continue;
        }
        res.add(nodeDepths[i]);
      }
      return res;
    }
