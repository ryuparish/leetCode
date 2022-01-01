// Gist: Use a stack to keep track of the current state of the return-list-to-be. Then, loop through and use a 
// break statement to break two loops to prevent accidental adding of a destroyed meteor. Then, branch out conditionals.
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<Integer>();
        for(int ast : asteroids){
            // Only the situation where currasteroid goes right and next asteroid goes left matters.
            collision: {
                while(!asteroidStack.isEmpty() && asteroidStack.peek() > 0 && ast < 0){
                    if(asteroidStack.peek() < -ast){
                        asteroidStack.pop();
                        continue; // (need to loop to see next state)
                    }
                    else if(asteroidStack.peek() == -ast){
                        asteroidStack.pop(); // Now in a state where both asteroids are destroyed (no push)
                    }
                    break collision; // Now in a state where the next asteroid should be destroyed (no push)
                }
                asteroidStack.push(ast);
            }
        }
        int[] ans = new int[asteroidStack.size()];
        for(int i = ans.length-1; i > -1; --i){
            ans[i] = asteroidStack.pop();
        }
        return ans;
    }
}
