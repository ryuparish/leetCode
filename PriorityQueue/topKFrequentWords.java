// TC: O(nlogn)[max-heapify for each additional node], O(n) HashMap storage
// Gist: Count the words to their frequency and then use a priority queue to save only the top k values.
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < words.length; ++i){
            wordFrequency.put(words[i], wordFrequency.getOrDefault(words[i], 0) +1);
        }
        
        // Making priority queue that sorts by value if different values and alphabetical if values are the same
        // Sorts from greatest -> least in contrast to usual least -> greatest in priority queues
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        // It seems that priority queue polls from the bottom node
        for(Map.Entry<String, Integer> wordFreq : wordFrequency.entrySet()){
            pq.offer(wordFreq);
            
            // Max Heap will run in the backend when we run
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        // We now need to add backwards, because the poll added from the least-greatest value to the greatest-greatest value
        while(pq.size() > 0){
            answer.add(0, pq.poll().getKey());
        }
        return answer;
    }
}
