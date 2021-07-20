class Solution {
public:
    int lengthOfLastWord(string s) {
        int wordLength = 0;
        bool latest = true;
        for(int i = 0; i < s.size(); ++i){
            if(s[i] != ' ' && latest){wordLength = 1; latest = false;}
            else if(s[i] != ' ' && !latest){wordLength++;}
            else if(s[i] == ' '){latest = true;}
        }
        return wordLength;
    }
};
