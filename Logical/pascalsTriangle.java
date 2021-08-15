class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        List<Integer> prevRow = new ArrayList<Integer>();
        for(int i = 1; i < numRows+1; ++i){
            List<Integer> currRow = new ArrayList<Integer>(i);
            for (int k = 0; k < i; k++)
                currRow.add(1);
            for(int j = 1; j < i-1; ++j)
                currRow.set(j, prevRow.get(j-1) + prevRow.get(j));
            answers.add(currRow);
            prevRow = new ArrayList<Integer>(currRow);
        }
        return answers;
    }
}
