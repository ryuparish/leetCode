// Original Solution:
class MinStack {
    List<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        this.stack.add(val);
    }
    
    public void pop() {
        this.stack.remove(this.stack.size()-1);
    }
    
    public int top() {
        return this.stack.get(this.stack.size()-1);
    }
    
    public int getMin() {
        return this.getMin(0);
    }
    
    public int getMin(int currValue){
        return currValue + 1 == this.stack.size() ? this.stack.get(currValue) : Math.min(this.stack.get(currValue), this.getMin(++currValue));
    }
}

// Optimal Solution:
//class MinStack {
//    Stack<Integer> stack;
//    int min = Integer.MAX_VALUE;
//
//    /** initialize your data structure here. */
//    public MinStack() {
//        this.stack = new Stack<Integer>();
//    }
//    
//    // The key is to add a copy of the previous min under the current min
//    // We will poptwice and keep the second pop as the min when we pop this value
//    public void push(int val) {
//        if(this.min >= val){
//            this.stack.push(this.min);
//            this.min = val;
//        }
//        this.stack.push(val);
//    }
//    
//    public void pop() {
//        if(this.stack.pop() == this.min){
//            this.min = this.stack.pop();
//        }
//    }
//    
//    public int top() {
//        return this.stack.peek();
//    }
//    
//    public int getMin() {
//        return this.min;
//    }
//}
