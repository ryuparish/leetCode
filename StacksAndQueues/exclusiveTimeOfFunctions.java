// Start and End interval behaviors
// x     -> y
// Ends and starts are always exclusive of the previously program except the 
// Start -> Start (y-x) add to current then push
// Start -> End ((y+1)-x) add to current then pop
// End -> End (y-x) add to current then pop
// End -> Start (y-(x+1)) add to current then pop 
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        // Program never starts or never ends
        if(logs.size() < 2){return new int[0];}
        int[] answer = new int[n];
        String[] pidStatusPosition = logs.get(0).split(":");
        String currStatus = pidStatusPosition[1], nextStatus;
        int position = 0, nextPosition, nextPid, diff;
        Stack<Integer> pidStack = new Stack<Integer>();
        for(int i = 0; i < logs.size(); ++i){
            // Parsing the current log
            pidStatusPosition = logs.get(i).split(":");
            nextPosition = Integer.parseInt(pidStatusPosition[2]);
            nextStatus = pidStatusPosition[1];
            nextPid = Integer.parseInt(pidStatusPosition[0]);
            diff = toInt(currStatus) - toInt(nextStatus);
            
            // If stack is empty, just push and move on
            if(pidStack.isEmpty()){
                currStatus = nextStatus;
                position = nextPosition;
                pidStack.push(nextPid);
            }
            
            // If it is the special start -> end condition
            if(diff == -1){answer[pidStack.peek()] += (nextPosition+1) - position;}
            
            // If it is the special end -> start condition
            else if(diff == 1){answer[pidStack.peek()] += nextPosition - (position+1);}
            else{answer[pidStack.peek()] += nextPosition - position;}
            
            // Adding or popping from stack
            if(toInt(nextStatus) == 1){pidStack.pop();}
            else{pidStack.push(nextPid);}
            position = nextPosition;
            currStatus = nextStatus;
        }
        return answer;
    }
    
    private int toInt(String bound){
        if(bound.compareTo("end") == 0){return 1;}
        return 0;
    }
}
