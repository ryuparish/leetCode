// This is the type of problem where trying to simplify things will cause you death by a thousand cuts
class Solution {
    public String addBinary(String a, String b) {
        int remainder = 0, aPosition, bPosition, currValue = 0;
        StringBuilder returnString = new StringBuilder();
        aPosition = a.length() - 1;
        bPosition = b.length() - 1;
        while(aPosition >= 0 || bPosition >= 0){ 
            if(aPosition >=0){currValue += Character.getNumericValue(a.charAt(aPosition--));}
            if(bPosition >=0){currValue += Character.getNumericValue(b.charAt(bPosition--));}
            currValue += remainder;
            returnString.append(Integer.toString(currValue % 2));
            remainder = currValue / 2;
            currValue = 0;
        }
        if(remainder > 0){
            returnString.append("1");
        }
        return returnString.reverse().toString();
    }
}
