// Gist: An addition stack the automatically does all multiplication and division first.
// OR we can use two integers and a char, looking at the numbers one at a time with delay.
// 
// "Charge & Release"
// The two numbers work by using the plus, minus, and end as release operators and the
// multiply and divide as "charge up" operators. LeadNum will be sent to charge and charge
// will either be augmented or sent to sum.
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int charge = 0;
        int leadNum = 0;
        // Default to addition because we always add the first number
        char operator = '+';
        for(int i = 0; i < s.length(); ++i){
            char currChar = s.charAt(i);
            // If it is a digit, then it should be added to the currNumber
            if(Character.isDigit(currChar)){
                leadNum = (leadNum * 10) + (currChar - '0');
            }
            // It can also be a non-digit, but be a space at the end of expression
            // It can also be a digit AND at the end of the expression.
            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length()-1){
                // This will only run when we reach a number AFTER a plus, minus, or the 
                // end of the expression.
                // Release and restart
                if(operator == '+' || operator == '-'){
                    sum += charge;
                    charge = (operator == '+') ? leadNum : -leadNum;
                }
                else if(operator == '/'){
                    charge /= leadNum;
                }
                else if(operator == '*'){
                    charge *= leadNum;
                }
                operator = currChar;
                // Since this is possibly after a multiply or divide charge up,
                // we also need to make sure to reset the growing leadNum since the charge
                // is already accounted for.
                leadNum = 0;
            }
        }
        // If the last was multiply then the charge is released here, else, the last
        // number is added.
        sum += charge;
        return sum;
    }
}
