// 100% time and 99% space
class Solution {
    public List<Integer> getRow(int numRows) {
        int[] lagRow = new int[numRows+1];
        int[] leadRow = new int[numRows+1];
        int[] swapper;
        Arrays.fill(lagRow, 1);
        Arrays.fill(leadRow, 1);
        int stopHead = -2;
        while(stopHead <= numRows){
            for(int j = 1; j < stopHead; ++j){
                leadRow[j] = lagRow[j-1] + lagRow[j];
            } 
            swapper = leadRow;
            leadRow = lagRow;
            lagRow = swapper;
            stopHead++;
        }
        List<Integer> answer = new ArrayList<Integer>();
        for(int i : lagRow)
            answer.add(i);
        return answer;
    }
}
