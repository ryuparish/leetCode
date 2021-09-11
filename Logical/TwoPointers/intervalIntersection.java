// Gist: Compare both of the intervals then either add and move the section with the shorter end or just move the
// section with the shorter end. The inner bounds of the intervals will always will valid or invalid in a single
// way.
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> answerArray = new ArrayList<int[]>();
        int firstPos = 0, secondPos = 0;
        while(firstPos < firstList.length && secondPos < secondList.length){
            // Move the shorter end heuristic
            // Getting the inner bounds
            int end = Math.min(firstList[firstPos][1], secondList[secondPos][1]);
            int begin = Math.max(secondList[secondPos][0], firstList[firstPos][0]);
            // If the beginning of the first section is in between the second section or vice versa
            if(end >= begin){
                answerArray.add(new int[] {begin, end});
            }
            if(firstList[firstPos][1] >= secondList[secondPos][1]){secondPos++;}
            else{firstPos++;}
        }
        return answerArray.toArray(new int[answerArray.size()][]);
    }
}
