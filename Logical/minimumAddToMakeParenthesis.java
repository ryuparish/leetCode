// TC: O(n), SC: O(n)
//class Solution {
//    public int minAddToMakeValid(String s) {
//        Stack<Character> parenStack = new Stack<Character>();
//        for(int i = 0; i < s.length(); ++i){
//            if(parenStack.isEmpty()){
//                parenStack.push(s.charAt(i));
//            }
//            else if(s.charAt(i) == ')' && parenStack.peek() == '('){
//                parenStack.pop();
//            }
//            else{
//                parenStack.push(s.charAt(i));
//            }
//        }
//        return parenStack.size();
//    }
//}
// TC: O(n) SC: O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int posOffset = 0;
        int wasteCloses = 0;
        for(int i = 0; i < s.length(); ++i){
            posOffset += s.charAt(i) == '(' ? 1 : -1;
            if(posOffset == -1){
                wasteCloses++;
                posOffset++;
            }
        }
        // Adding the wasteCloses and the posOffset extras 
        return wasteCloses + posOffset;
    }
}
