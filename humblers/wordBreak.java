class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // The dp part comes in when you are trying to keep track of where another word is
        // 'allowed' to start. This is due to the fact that if there is a single word down the
        // string, then there must be a second word before it for this to work.
        // We also abuse the fact that substring uses the last index as the "until" mark rather
        // than the literal index.
        boolean[] canStart = new boolean[s.length()+1];
        canStart[0] = true;
        for(int i = 1;  i < canStart.length; ++i){
            for(int j = 0; j < i; ++j){
                if(canStart[j] && wordDict.contains(s.substring(j, i))){
                    canStart[i] = true; // abusing substring to place next safe spot for next word
                    break;
                }
            }
        }
        return canStart[s.length()]; // This is because is the last element in the s.length() +1 size
        // array is true, then the entire word was made up of the words in the dictionary.
    }
}
