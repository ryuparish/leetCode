// The gist is the rent out a new room every time a meeting starts and the earliest-ending meeting is not
// over. If the earliest-ending meeting is over, then we replace that room with the next earliest-ending 
// meeting. We never remove any rooms.

// When there is many rooms empty and only a few rooms occupied, this is not seen or cared for, since we only care when the room number increases.
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // First we need to create a Min-Heap
        // Priority Queue automatically does the min-Heapify function
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        // Sort array by begin time
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        // Check the min Heap every time we add a room.
        // This min-Heap will expand but will never lower in size.
        // This will add to the size only when there is not a free room available. It will never lower,
        // only replace one node in the head at a time.
        minHeap.offer(intervals[0][1]);
        for(int i = 1; i < intervals.length; ++i){
            // Replacing minHeap top 
            if(minHeap.peek() <= intervals[i][0]){
                minHeap.poll();
            }
            // Adding current ending if there is a vacant room
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}
