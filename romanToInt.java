import java.util.*;
class Solution {
    public static void main(String[] args) {
        String s = args[0];
        int sum = 0;
        Hashtable<Character, Integer> myTable = new Hashtable<Character, Integer>();
        myTable.put('I', 1);
        myTable.put('V', 5);
        myTable.put('X', 10);
        myTable.put('L', 50);
        myTable.put('C', 100);
        myTable.put('D', 500);
        myTable.put('M', 1000);
        
        // Getting the first character and making it our current char
        char curr_char = s.charAt(0);
        for(int i = 1; i < s.length(); ++i){

            System.out.println("Value of curr_char");
            System.out.println(curr_char);
            // If the new character is not equal to the current one
            if(Character.compare(curr_char, s.charAt(i)) != 0){
                
                // If the character is greater, then substract from the current charAt(i) and add to sum
                if(myTable.get(curr_char) < myTable.get(s.charAt(i))){
                    sum += myTable.get(s.charAt(i)) - myTable.get(curr_char);
                    // If we can get the next letter after subtracting
                    if(i+1 < (s.length())){
                        curr_char = s.charAt(i+1);
                        ++i;
                    }
                    else{curr_char = ' ';}
                }
                
                // If the next letter is less than the current charAt(i)
                else{
                    sum += myTable.get(curr_char);
                    curr_char =  s.charAt(i);
                }
            }
            
            // If the letters are the same
            else{
                sum += myTable.get(curr_char);
                curr_char = s.charAt(i);
            }
            
        }
        // Adding the last letter since it does not have a next character
        if(curr_char != ' '){
            sum += myTable.get(curr_char);
        }
        System.out.println(sum);
        return;
    }
}
