// Gist: Make a static array of the number of dependencies for each node, a list for each dependency with the
// dependent nodes as a list within that index, and finally a queue for the bfs. Loop through to find all 
// nodes with no dependencies and perform bfs, adding every dependent node that lost all dependencies to the 
// queue.
// TC: O(E + V), SC: O(E+V)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int classTaken = 0;
        int n = numCourses;
        int[] numDep = new int[n];
        List<List<Integer>> adj = new ArrayList<List<Integer>>(n);
        while(n-- > 0){adj.add(new ArrayList<Integer>());}
        makeGraph(prerequisites, numDep, adj);
        Queue<Integer> myQueue = new LinkedList<Integer>();
        // Adding free nodes to the queue
        for(int i = 0; i < numDep.length; ++i){
            if(numDep[i] == 0){
                myQueue.offer(i);
                classTaken++;
            }
        }
        while(!myQueue.isEmpty()){
            int currNode = myQueue.poll();
            for(int ind : adj.get(currNode)){
                numDep[ind]--;
                if(numDep[ind] == 0){
                    classTaken++;
                    myQueue.offer(ind);
                }
            }
        }
        return classTaken == numCourses;
    }
    private void makeGraph(int[][] prereqs, int[] numDep, List<List<Integer>> adj){
        for(int[] pair : prereqs){
            numDep[pair[0]]++;
            adj.get(pair[1]).add(pair[0]);
        }
        return;
    }
}
