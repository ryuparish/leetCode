class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> answers = new LinkedList<>();
        for(int i = 0; i < intervals.length; ++i){
            // Base Case where we need to make an interval
            if(answers.isEmpty() || answers.getLast()[1] < intervals[i][0]){
                answers.add(intervals[i]);
            }
            
            // Where we need to extend the last interval
            else{
                answers.getLast()[1] = Math.max(answers.getLast()[1], intervals[i][1]);
            }
        }
        return answers.toArray(new int[answers.size()][2]);
    }
}
