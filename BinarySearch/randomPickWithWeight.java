class Solution {
    int[] tickets;
    int allTickets;
    int length;
    public Solution(int[] w) {
        length = w.length;
        int cumSum = 0;
        tickets = new int[length];
        for(int i = 0; i < this.length; ++i){
            cumSum += w[i];
            tickets[i] = cumSum;
        }
        allTickets = cumSum;
    }
    
    public int pickIndex() {
        double ticket = Math.random() * allTickets;
        int lo = 0, high = length;
        while(lo < high){
            int mid = lo + (high - lo)/2;
            if(ticket < tickets[mid]){high = mid;}
            else{lo = mid+1;}
        }
        return lo; // we can return high too, they converge to the same value at the end.
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
