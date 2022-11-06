class Solution {
    class CustomStack {
        private final int[] cStack;
        private int topOfStack;
    
        public CustomStack(int maxSize) {
          cStack = new int[maxSize];
          topOfStack = -1;
        }
        
        public void push(int x) {
          if (topOfStack == cStack.length - 1) {
            return;
          }
          // Inc then insert
          cStack[++topOfStack] = x;
        }
        
        public int pop() {
          if (topOfStack == -1) {
            return -1;
          }
          // Return then decrement
          return cStack[topOfStack--];
        }
        
        public void increment(int k, int val) {
          int limit = Math.min(k, cStack.length);
          for (int i = 0; i < limit; ++i) {
            cStack[i] += val;
          }
        }
    }
}
