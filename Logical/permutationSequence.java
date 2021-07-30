class Solution {
    public String getPermutation(int n, int k) {
        // Create the choices array
        ArrayList<Integer> choices = new ArrayList<Integer>();
        for(int i = 1; i <= n; ++i){
            choices.add(i);
        }

        StringBuilder myAnswer = new StringBuilder();
        // Create the factorial array
        ArrayList<Integer> factorials = new ArrayList<Integer>();
        factorials.add(1);
        int currFactorial = 1;
        for(int i = 1; i < n; ++i){
            currFactorial *= i;
            factorials.add(currFactorial);
        }
        
        // Build the string using the formulas
        int currIdx = 0;
        for(int i = 1; i <= n; ++i){
            currIdx = (k-1)/factorials[n-i];
            myAnswer.append(Integer.toString(choices[currIdx]));
            choices.remove(currIdx);
            k -= currIdx * factorialxn-i;
        }
        return myAnswer;
    }
}
