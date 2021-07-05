import java.util.*;

class Solution {
    public static ArrayList<String> makeStrings(String s, int numRows){
        // Edge Case where the numRows is 1 and therefore the string is the same as the smushed version
        if(numRows == 1){
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }
        // Making an array list of strings for each row
        ArrayList<String> list = new ArrayList<String>(numRows);
        for(int i = 0; i < numRows; ++i){
            list.add(""); 
        }
        // This will be multiplied by i * (
        int verticalSkipRate = numRows * (numRows-1);

        int stringTraveler = 0;
        // Adding to the arraylist strings
        for(int i = 0; stringTraveler < s.length(); i += numRows){
            // There are two different behaviors. Adding to each string when on a zigzag diagonal and adding to each string when on a zigzag vertical
           
            // Case of Vertical
            if(i == 0 || i % (numRows-1) == 0){
                for(int j = 0; j < numRows; ++j){
                    // Edge case where the word is out of letters 
                    if(stringTraveler >= s.length()){
                        break;
                    }
                    String charToAdd = Character.toString(s.charAt(stringTraveler));
                    list.set(j, list.get(j).concat(charToAdd));
                    stringTraveler++;
                }
            }

            // Case of Diagonal
            else{
                for(int j = 0; j < numRows; ++j){
                    // Edge case where the word is out of letters 
                    if(stringTraveler > s.length()){
                        break;
                    }
                    
                    // If this is where the zigzag is a letter rather than a space
                    if(j == (numRows - (i % (numRows - 1)) - 1)){
                        String charToAdd = Character.toString(s.charAt(stringTraveler));
                        list.set(j, list.get(j).concat(charToAdd));
                        stringTraveler++;
                    }
                    // Adding a space otherwise
                    else{
                        list.set(j, list.get(j).concat(" "));
                    }
                }
            }
        }

        return list;
    }
    
    // LeetCode Main (no static)
    //public String convert(String s, int numRows){
    //    ArrayList<String> myStrings = new ArrayList<>();
    //    myStrings = makeStrings(s, numRows);
    //    for(int i = 0; i < myStrings.size(); ++i){
    //        System.out.println(myStrings.get(i));
    //    }
    //}

    public static void main(String[] args){
        ArrayList<String> myStrings = new ArrayList<>();
        myStrings = makeStrings(args[0], Integer.parseInt(args[1]));
        System.out.println("Here is the zigzag version of the string:");
        for(int i = 0; i < myStrings.size(); ++i){
            System.out.println(myStrings.get(i));
            myStrings.set(i, myStrings.get(i).replaceAll("\\s", ""));
        }
        System.out.println("Here is the smushed version:");
        String smushedString = "";
        for(int i = 0; i < myStrings.size(); ++i){
            smushedString += myStrings.get(i);
        }
        System.out.println(smushedString);
    }
}
