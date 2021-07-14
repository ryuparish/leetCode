class Solution{
    public static String longestCommonPrefix(String[] strs){
        String output = "";
        if(strs.length < 1){
            return output;
        }
        int stringIndex = 0;
        char currMatch;
        while(true){
            if(stringIndex >= strs[0].length()){
                return output;
            }
            else{currMatch = strs[0].charAt(stringIndex);}
            for(int i = 0; i < strs.length; ++i){
                // Out of characters for a string
                if(stringIndex >= strs[i].length()){
                    return output;
                }
                else if(strs[i].charAt(stringIndex) != currMatch){
                    return output;
                }
            }
            output += Character.toString(currMatch);
            stringIndex++;
        }
    }
    //public static void main(String[] args){
    //    String prefix = longestCommonPrefix(args);
    //    System.out.println(prefix);
    //    return;
    //}
}
