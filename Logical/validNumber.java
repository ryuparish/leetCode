// Cases that are invalid
// 1. More than 2 signs (+, -)
// 2. More than 1 of the same sign before an e/E or after an e/E 
// 3. Consecutive signs
// 4. Signs that are not either the first symbol or the symbol right after e/E
// 5. More than one e/E
// 6. An e/E followed by a decimal
class Solution {
    public boolean isNumber(String s) {
        // sideHasSign resets to false after hasE is true
        int signCounter = 0, decimalCounter = 0; 
        boolean hasE = false, sideHasSign = false, validSignSpot = true, eIsValid = false, digitAfterE = false, hasDigit = false;
        for(int i = 0; i < s.length(); ++i){
            char currChar = s.charAt(i);
            //System.out.println(currChar);
            // Checking for Sign in the very beginning and right after an e/E
            if(validSignSpot && !sideHasSign && signCounter < 2 && (currChar == '-' || currChar == '+')){
                sideHasSign = true;
                validSignSpot = false;
                signCounter++;
            }
            // Checking for valid number (a digit, a dot, or e/E)
            // Checking for a dot (must be only one dot and before e/E)
            else if(currChar == '.' && decimalCounter < 1 && !hasE){
                decimalCounter++;
                validSignSpot = false;
            }
            // Checking for e/E (can only occur once)
            else if(eIsValid && !hasE && (currChar == 'e' || currChar == 'E')){
                sideHasSign = false;
                validSignSpot = true;
                hasE = true;
            }
            // Checking for a valid digit (ASCII can only be above 48 and below 57)
            else if((int)currChar >= 48 && (int)currChar <= 57){
                if(hasE){
                    digitAfterE = true;
                }
                hasDigit = true;
                validSignSpot = false;
                eIsValid = true;
            }
            else{
                return false;
            }
        }
        // Checking for the valid e case
        if(hasE){
            return digitAfterE;
        }
        if(decimalCounter > 0){
            return hasDigit;
        }
        return true;
    }
 	
	//public static void main(String[] args){
 //       Solution mySolution = new Solution();
 //       //String myString = new String("-123.456e789");
 //       String myString = new String("e3");
 //       boolean myAnswer = mySolution.isNumber(myString);
 //       System.out.println(myAnswer);
 //       return;
 //   }
}

