// TC: O(n), SC: O(n)
class Solution {
    //public int[] findBuildings(int[] heights) {
    //    int maxHeight = 0;
    //    List<Integer> oceanViews = new ArrayList<Integer>();
    //    for(int i = heights.length-1; i >= 0; --i){
    //        if(heights[i] > maxHeight){
    //            oceanViews.add(0, i);
    //            maxHeight = heights[i];
    //        }
    //    }
    //    int[] answer = oceanViews.stream().mapToInt(i->i).toArray();
    //    return answer;
    //}
    // In this case, it seems that looping twice is faster than adding memory to a List
    public int[] findBuildings(int[] heights) {
        int higher = 0, count = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > higher) {
                higher = heights[i];
                heights[i] = 0;
                count++;
            }
        }
        int[] indexes = new int[count];
        int index = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0) {
                indexes[index++] = i;
            }
        }
        return indexes;
    }
}
