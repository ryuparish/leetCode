// Optimal Solution
// TC: O(n^2) SC: O(n^2)
class Solution {
    // Main Function
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Making list and then filling up the capacity with the actual empty arrays
        List<List<Integer>> adj = new ArrayList<List<Integer>>(numCourses);
        int[] inboundCount = new int[numCourses];
        while(numCourses-- > 0){adj.add(new ArrayList<Integer>());}
        initializeGraph(inboundCount, adj, prerequisites);
        return bfs(inboundCount, adj);
    }
    // Function to initialize the graph that will show how many nodes depend on a single node
    private void initializeGraph(int[] inboundCount, List<List<Integer>> adj, int[][] prerequisites){
        int n = inboundCount.length;
        for(int[] link : prerequisites){
            // Adding inbound count to the restricted course
            // inbounds are prerequisites
            inboundCount[link[0]]++;
            // Adding an outbound count to the prereq
            // Meant for clearing prereqs during bfs
            adj.get(link[1]).add(link[0]);
        }
    }
    // BFS function
    private int[] bfs(int[] inboundCount, List<List<Integer>> adj){
        int order[] = new int[inboundCount.length];
        int visited = 0;
        Deque<Integer> myQueue = new LinkedList<Integer>();
        // Enqueueing all of the nodes that are free
        for(int i = 0; i < inboundCount.length; ++i){
            if(inboundCount[i] == 0){myQueue.offer(i);}
        }
        // Dequeueing then adding it's connections to the queue if they are free nodes now
        while(!myQueue.isEmpty()){
            int currNode = myQueue.poll();
            order[visited++] = currNode;
            for(int course : adj.get(currNode)){
                // One less dependency for the course connected to this dependency
                inboundCount[course]--;
                if(inboundCount[course] == 0){myQueue.offer(course);}
            }
        }
        return visited == inboundCount.length ? order : new int[0];
    }
}
