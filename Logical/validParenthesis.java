// This works, but there is an alternative, more efficient solution below
// The idea is to use a stack to push and pop and keep track of validating which closing bracket can be popped next while using the stack itself
// to check(isEmpty()) if the parenthesis were all matched rather than bookkeeping with ints.
// 
// Then, use a Symmetrical Hashmap to cleanly take care of the conditionals in a clean manner.
class Solution{
    public static boolean isValid(String s){
        if(s.length() < 2){
            return false;
        }
        int parenCount = 0, squareCount = 0, curlyCount = 0;
        String record = "";
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(' && i + 1 < s.length() && (s.charAt(i+1) != '(' && s.charAt(i+1) != '[' && s.charAt(i+1) != '{') && s.charAt(i+1) != ')'){
                return false;
            }
            else if(s.charAt(i) == '[' && i + 1 < s.length() && (s.charAt(i+1) != '(' && s.charAt(i+1) != '[' && s.charAt(i+1) != '{') && s.charAt(i+1) != ']'){
                return false;
            }
            else if(s.charAt(i) == '{' && i + 1 < s.length() && (s.charAt(i+1) != '(' && s.charAt(i+1) != '[' && s.charAt(i+1) != '{') && s.charAt(i+1) != '}'){
                return false;
            }
            else{
                if(s.charAt(i) == '('){
                    record += Character.toString('(');
                    parenCount++;
                }
                else if(s.charAt(i) == '['){
                    record += Character.toString('[');
                    squareCount++;
                }
                else if(s.charAt(i) == '{'){
                    record += Character.toString('{');
                    curlyCount++;
                }
                else if(s.charAt(i) == ')'){
                    parenCount--;
                    if(parenCount < 0 || record.charAt(record.length()-1) != '('){
                        return false;
                    }
                    record = record.substring(0,record.length()-1);
                }
                else if(s.charAt(i) == ']'){
                    squareCount--;
                    if(squareCount < 0 || record.charAt(record.length()-1) != '['){
                        return false;
                    }
                    record = record.substring(0,record.length()-1);
                }
                else{
                    curlyCount--;
                    if(curlyCount < 0 || record.charAt(record.length()-1) != '{'){
                        return false;
                    }
                    record = record.substring(0,record.length()-1);
                }
            }
        }
        if(record.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        String pattern = args[0];
        System.out.println(isValid(pattern));
        return;
    }
}

// Much more elegant 
//class Solution {
//    public boolean isValid(String s) {
//        HashMap<Character,Character> maps=new HashMap<Character,Character>();
//        maps.put(')','(');
//        maps.put(']','[');
//        maps.put('}','{');
//        Stack<Character> stack=new Stack<Character>();
//        for(int i=0;i<s.length();i++){
//            char c=s.charAt(i);
//            if(maps.containsKey(c)){
//                if(stack.empty()||stack.pop()!=maps.get(c))return false;
//            }
//            else
//                stack.push(c);
//        }
//        return stack.empty();
//    }
//}
