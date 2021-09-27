class Solution{
    public static String intToRoman(int num){
        HashMap<Integer, Character> myMap = new HashMap<>();
        myMap.put(1,'I');
        myMap.put(5,'V');
        myMap.put(10,'X');
        myMap.put(50,'L');
        myMap.put(100,'C');
        myMap.put(500,'D');
        myMap.put(1000,'M');

        int digits = 0;
        int currentDigit;
        int origNum = num;
        StringBuilder romanNum = new StringBuilder();
        
        // Counting the number of digits in the number
        while(num > 0){
            num /= 10;
            ++digits;
        }
        for(int i = 0; i < digits; ++i){
            int onedCurrPlace = (int)Math.pow(10, digits-(i));
            int onedLeftPlace = (int)Math.pow(10, (digits-(i+1)));
            
            
            // Removing any digits in front, then removing all the digits behind the current place we are looking.
            currentDigit = (int)Math.floor((origNum % onedCurrPlace) / onedLeftPlace);

            // First check if the digit is a 4 or a 9, if else then we can do modulo 5 then the remaining smaller value
            // Removing any digits in front, then removing all the digit behind the number
            if(currentDigit != 4 && currentDigit != 9){
                
                // If the number is between 4 and 9 (exclusive for both endpoints), then we need to first add the 5-roman
                // numeral.
                if(currentDigit >= 5){
                    
                    // Getting the correct 5-roman numeral
                    romanNum.append(myMap.get(5 * onedLeftPlace));
                    currentDigit -= 5;
                }
                
                // Remaining amount after 5 roman-character has been placed.
                for(int j = 0; j < currentDigit; ++j){
                    romanNum.append(myMap.get(onedLeftPlace));
                }
            }
            
            // If digit is a four or a nine
            else{
                if(currentDigit == 9){
                    
                    // 9 is special because we need to get the 1'd version of the current position and
                    // then get the 10'd version of the current position (which is just using i instead of i+1)
                    romanNum.append(myMap.get(onedLeftPlace));
                    romanNum.append(myMap.get(onedCurrPlace));
                }
                else{
                    
                    // 4 is special because we need to get the 1'd version of the current position and
                    // then get the 5'd version of the current position
                    romanNum.append(myMap.get(onedLeftPlace));
                    romanNum.append(myMap.get(5 * onedLeftPlace));
                }
            }
        }
        return romanNum.toString();
    }
}
