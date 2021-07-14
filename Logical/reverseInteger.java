// Try removing this and seeing if it still works
import java.util.*;
class Solution {

    public static String removeZeros(String userString){
        while(userString.charAt(userString.length() - 1) == '0'){
            userString = userString.substring(0, userString.length() -1);
        }
        return userString;
    }

    public static void reverse(int x) {
        // Maybe this way instead
        //String stringx = Integer.toString(x);
        String stringx = Integer.toString(x);
        boolean negCell = false;

        // Adding the negative back to the front if there it is negative
        if(x < 0){
            stringx.substring(1, stringx.length());
            negCell = true;
        }
        stringx = removeZeros(stringx);

        // Inserting negative if necessary 
        if(negCell){
            stringx = "-" + stringx;
        }
        System.out.println(stringx);
        return;
    }

    public static void main(String[] args) {
        if(Objects.equals(args[0], "0")){
            System.out.println(args[0]);
            return;
        }

        //String stringx = Integer.toString(args[0]);
        String stringx = args[0];
        boolean negCell = false;
        int x = Integer.parseInt(stringx);

        // Adding the negative back to the front if there it is negative
        if(x < 0){
            stringx = stringx.substring(1, stringx.length());
            negCell = true;
        }
        stringx = removeZeros(stringx);

        // Reversing the string
        stringx = new StringBuilder(stringx).reverse().toString();

        // Inserting negative if necessary 
        if(negCell){
            stringx = "-" + stringx;
        }
        int stringInt = Integer.parseInt(stringx);
        System.out.println(stringInt);
        return;
    }
}
