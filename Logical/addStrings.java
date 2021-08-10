class Solution {
    public String addStrings(String num1, String num2) {
        int num1pointer = num1.length()-1;
        int num2pointer = num2.length()-1;
        int carryOver = 0, sum = 0;
        StringBuilder myStringBuilder = new StringBuilder();
        while(num1pointer >= 0 || num2pointer >= 0 || carryOver != 0){
            int num1Value = 0;
            int num2Value = 0;
            if(num1pointer >= 0){
                num1Value = num1.charAt(num1pointer--) - '0';
            }
            if(num2pointer >= 0){
                num2Value = num2.charAt(num2pointer--) - '0';
            }
            sum = num1Value + num2Value + carryOver;
            carryOver = (int)((sum) / 10);
            
            myStringBuilder.append((char)((sum % 10) + '0'));
        }
        return myStringBuilder.reverse().toString();
    }
}
