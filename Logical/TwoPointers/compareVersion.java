// Gist: We utilize a function we define called "getChunk" that will convert the number between
// two periods into an integer. We then do this in parallel, starting at 0 and until both
// strings are travelled through. If one stop shorter than the other we will continuously return
// 0 for each consecutive comparision until both strings are at their ends.

// TC: O(max(m, n)), SC: O(m, n)
//class Solution {
//    
//    // This function will find the number chunk and the new starting point and return
//    // them in a pair
//    public Pair<Integer, Integer> getChunk(String version, int head){
//        int size = version.length() - 1;
//        
//        // Returning 0 if head string is alread finished
//        if(head > size){return new Pair(0,head);}
//        
//        // Finding the chunk (this is easier for computation and grasp)
//        int end = head, chunkNum;
//        while(end <= size && version.charAt(end) != '.'){
//            end++;
//        }
//        
//        // Getting the integer
//        chunkNum = Integer.parseInt(version.substring(head, end));
//        head = end + 1;
//        return new Pair(chunkNum, head);
//    }
//    
//    public int compareVersion(String version1, String version2) {
//        int v1Head = 0, v2Head = 0, v1Length = version1.length(), v2Length = version2.length();
//        
//        // Loop until both reach their ends 
//        while(v1Head < v1Length || v2Head < v2Length){
//            
//            // Getting the next chunks from both versions (defaults to 0 if at end)
//            Pair<Integer, Integer> v1Num = getChunk(version1, v1Head);
//            v1Head = v1Num.getValue();
//            Pair<Integer, Integer> v2Num = getChunk(version2, v2Head);
//            v2Head = v2Num.getValue();
//            
//            // Comparing then returning if different
//            if(v1Num.getKey() != v2Num.getKey()){
//                return v1Num.getKey() > v2Num.getKey() ? 1 : -1;
//            }
//        }
//        return 0;
//    }
//}
// Simpler, faster solution
// Same TC and SC
class Solution{
    public int compareVersion(String version1, String version2){
        int v1Head = 0, v2Head = 0, v1End = version1.length(), v2End = version2.length();
        int temp1, temp2;
        while(v1Head < v1End || v2Head < v2End){
            temp1 = 0;
            temp2 = 0;
            // Getting the chunk from version1
            while(v1Head < v1End && version1.charAt(v1Head) != '.'){
                temp1 = temp1 *10 + version1.charAt(v1Head++) - '0';
            }
            // Getting the chunk from version1
            while(v2Head < v2End && version2.charAt(v2Head) != '.'){
                temp2 = temp2 *10 + version2.charAt(v2Head++) - '0';
            }
            if(temp1 != temp2){return temp1 > temp2 ? 1 : -1;}
            v1Head++;
            v2Head++;
        }
        return 0;
        
    }
}
