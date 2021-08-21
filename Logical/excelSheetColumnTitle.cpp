class Solution {
public:
    string convertToTitle(int n) {
        // It is like a backwards base 26 number in capital letter form:
        // ie : 734 = (26^2 * 1 ) * (26^1 * 2) * (26^0 * 6)
        //                    -             -            -
        //      == A B F 
        return n-- == 0 ? "" : convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }
};
