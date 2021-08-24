// Original Suboptimal Solution
// TC: O(n) SC: O(n)
class Solution {
    public String simplifyPath(String path) {
        if(path.charAt(path.length()-1) != '/'){path = path + "/";}
        Stack<String> myStack = new Stack<String>();
        StringBuilder newPath = new StringBuilder("/");
        StringBuilder directory = new StringBuilder();
        for(int i = 0; i < path.length(); ++i){
            if(path.charAt(i) == '/'){
                if(directory.toString().equals("..")){
                    if(myStack.size() > 1){
                        myStack.pop();
                        myStack.pop();
                    }
                }
                else if(directory.toString().equals(".")){
                    directory.setLength(0);
                }
                else if(directory.length() > 0){
                    myStack.push(directory.toString());
                    myStack.push("/");
                }
                directory.setLength(0);
            }
            else{directory.append(path.charAt(i));}
        }
        Stack<String> otherStack = new Stack<String>();
        while(myStack.size() > 0){
            otherStack.push(myStack.pop());
        }
        while(otherStack.size() > 1){
            newPath.append(otherStack.pop());
        }
        return newPath.toString();
    }
    // Optimal Clean Solution
    // TC: O(n) SC: O(n)
    //public String simplifyPath(String path) {
    //    Deque<String> stack = new LinkedList<>();
    //    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    //    for (String dir : path.split("/")) {
    //        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
    //        else if (!skip.contains(dir)) stack.push(dir);
    //    }
    //    String res = "";
    //    // Looping backwards in a way
    //    for (String dir : stack) res = "/" + dir + res;
    //    return res.isEmpty() ? "/" : res;
    //}
}
