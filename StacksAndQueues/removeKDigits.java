// Gist: A monotonically increasing stack is our goal. If we can tranform the digit into a monotonically increasing number
// then we would have achieved the minimum number while removing the minimum number of digits. We move from left to right 
// and add to a stack if the number we are currently on is larger than the top of the stack(repeatedly until not if we run out
// ). The remainder of stack will be our answer.
//
//  Note: We must remove exactly k digits!
// ie. 147298523 -> 1223, k = 5
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder answer = new StringBuilder();
        
        // Looping through the whole string
        for(int i = 0; i < num.length(); ++i){
            int currNum = num.charAt(i) - '0';
            
            // While the invalid status is true, answer still has letters, and k is not depleted
            while(k > 0 && answer.length() > 0 && answer.charAt(answer.length()-1) - '0' > currNum){
                k--;
                answer.setLength(answer.length() - 1);
            }
            
            // Avoiding the "0 in the front" answer
            if(currNum == 0 && answer.length() == 0){continue;}
            else{answer.append(String.valueOf(currNum));}
        }
        
        // Removing any of the last k
        while(k > 0 && answer.length() > 0){
            answer.setLength(answer.length()-1);
            k--;
        }
        return answer.length() == 0 ? "0" : answer.toString();
    }
}
