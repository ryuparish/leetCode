import java.util.*;
import java.lang.Math;
class Solution{
    public static String intToRoman(int num){
        HashMap<Double, Character> myMap = new HashMap<>();
        myMap.put(1.0,'I');
        myMap.put(5.0,'V');
        myMap.put(10.0,'X');
        myMap.put(50.0,'L');
        myMap.put(100.0,'C');
        myMap.put(500.0,'D');
        myMap.put(1000.0,'M');

        int digits = 0;
        double currentDigit;
        int origNum = num;
        String romanNum = "";
        while(num > 0){
            num /= 10;
            ++digits;
        }
        for(int i = 0; i < digits; ++i){
            // Removing any digits in front, then removing all the digit behind the number
            if(i+1 < digits){currentDigit = Math.floor((origNum % Math.pow(10, digits-(i))) / Math.pow(10, (digits-(i+1))));}
            // Just removing digits in front if it is a single digit to avoid nullDivision
            else{currentDigit = origNum % Math.pow(10, digits-(i));}

            // First check if the digit is a 4 or a 9, if else then we can do modulo 5 then the remaining smaller value
            // Removing any digits in front, then removing all the digit behind the number
            if(currentDigit != 4.0 && currentDigit != 9.0){
                if(currentDigit >= 5.0){
                    romanNum += Character.toString(myMap.get(5 * Math.pow(10, digits-(i+1))));
                    currentDigit -= 5.0;
                }
                while(currentDigit > 0){
                    romanNum += Character.toString(myMap.get(Math.pow(10, digits-(i+1))));
                    --currentDigit;
                }
            }
            else{
                if(currentDigit == 9.0){
                    romanNum += Character.toString(myMap.get(Math.pow(10, digits-(i+1))));
                    romanNum += Character.toString(myMap.get(Math.pow(10, digits-(i))));
                }
                else{
                    romanNum += Character.toString(myMap.get(Math.pow(10, digits-(i+1))));
                    romanNum += Character.toString(myMap.get(5 * Math.pow(10, digits-(i+1))));
                }
            }
        }
        return romanNum;
    }

    public static void main(String[] args){
        int myNum = 1994;
        String myRomanNum = intToRoman(myNum);
        System.out.println(myRomanNum);
        return;
    }
}
