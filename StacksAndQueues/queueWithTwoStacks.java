import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
      Stack<Long> headStack = new Stack<>();
      Stack<Long> reversalStack = new Stack<>();
      Scanner input = new Scanner(System.in);
      int queries = input.nextInt();
      int action = 0;
      
      // Looping until there are no more longs/integers to read in.
      while (input.hasNextInt()) {
        action = input.nextInt();
        // Enqueue
        if (action == 1) {
          Long newLong = input.nextLong();
          headStack.add(newLong);
        } else if (action == 2) {
          if (reversalStack.isEmpty()){
            
            // Getting the forward-most value from the queue.
            int originalSize = headStack.size();
            for (int i = 0; i < originalSize; ++i) {
              Long addLong = headStack.pop();
              reversalStack.add(addLong);
            }
          }
          
          // Popping the forward-most value from the queue.
          reversalStack.pop();
        } else {
          if (reversalStack.isEmpty()){
            
            // Getting the forward-most value from the queue.
            int originalSize = headStack.size();
            for (int i = 0; i < originalSize; ++i) {
              reversalStack.add(headStack.pop());
            }
          }
          
          // Peeking the forward-most value from the queue.
          System.out.println(reversalStack.peek());
        }
      }
      return;
    }
}
