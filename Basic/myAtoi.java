class Solution {
    public static int myAtoi(String s){
        // Subtracting or adding to a char converts the char into its
        // ascii integer value and then does the operation into an integer.
        int i = 0;
        // If string is blank
        if(i >= s.length()){return 0;}
        boolean neg = false;
		while(s.charAt(i) == ' '){
            ++i;
            if(i >= s.length()){
                return 0;
            }
        }
        // Checking if the first character is not a digit and not a minus/plus
        if((s.charAt(i) < 48 || s.charAt(i) > 57) && (s.charAt(i) != '-' && s.charAt(i) != '+')){
            return 0;
        }
        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            boolean isMinus = s.charAt(i) == '-';
            if(i + 1 >= s.length() || (s.charAt(i+1) < 48 || s.charAt(i+1) > 57)){
                return 0;
            }
            else if(isMinus){
                neg = true;
            }
            ++i;
        }
        String convertString = "";
        while(i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57){
            convertString += Character.toString(s.charAt(i));
            ++i;
        }
        boolean overflow = false;
        try{
            i = Integer.parseInt(convertString);
        }
        catch(Exception e){
            i = 2147483647;
            overflow = true;
        }
        if(neg){
            i *= -1;
            if(overflow){
                i -= 1;
            }
        }
        return i;
    }

    public static void main(String[] args){
        String myString = " ";
        int myInt = myAtoi(myString);
        System.out.println(myInt);
        return;
    }
}

