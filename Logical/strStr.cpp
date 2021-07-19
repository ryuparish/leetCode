class Solution {
public:
    int strStr(string haystack, string needle) {
        if(needle == ""){return 0;}
        // I think this is a variation of kadane's algorithm
        int matches = 0;
        bool keep;
        for(int i = 0; i < haystack.size(); ++i){
            keep = false;
            if(haystack[i] == needle[matches]){
                matches++;
                if(matches == needle.size()){return i;}
                for(int j = i + 1; j < haystack.size(); ++j){
                    if(haystack[j] == needle[matches]){
                        matches++;
                        if(matches == needle.size()){return i;}
                        continue;
                    }
                    break;
                }
            }
            matches = 0;
        }
        return -1;
    }
};
