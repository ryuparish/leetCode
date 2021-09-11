class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> parenStack = new Stack<Integer>();
        HashSet<Integer> removalIdx = new HashSet<Integer>();
        StringBuilder answer = new StringBuilder();
        // Recording the index if it is a surplus closing bracket or a surplus opening bracket towards
        // the end.
        for(int i = 0; i < s.length(); ++i){
            char currChar = s.charAt(i);
            if(currChar == '('){
                parenStack.push(i);
            }
            else if(currChar == ')'){
                if(!parenStack.isEmpty()){parenStack.pop();}
                else{removalIdx.add(i);}
            }
        }
        while(!parenStack.isEmpty()){removalIdx.add(parenStack.pop());}
        for(int i = 0; i < s.length(); ++i){
            if(removalIdx.contains(i)){
                continue;
            }
            answer.append(s.charAt(i));
        }
        return answer.toString();
    }
}
