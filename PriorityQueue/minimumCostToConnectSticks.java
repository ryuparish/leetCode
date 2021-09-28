// Gist: Use a priority queue to pop from. Pop twice and add the number to both the answer and back to the queue until
// priority queue has only one stick remaining.
// TC: O(nlogn) [logn is the time complexity of max-heapify], SC: O(n)
class Solution {
    public int connectSticks(int[] sticks) {
        int answer = 0;
        PriorityQueue<Integer> nums = new PriorityQueue<Integer>();
        for(int i = 0; i < sticks.length; ++i){
            nums.offer(sticks[i]);
        }
        while(nums.size() > 1){
            int newValue = nums.poll() + nums.poll();
            answer += newValue;
            nums.offer(newValue);
        }
        return answer;
    }
}
