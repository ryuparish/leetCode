import java.util.*;
class Solution {
    
    public List<List<String>> findNQueensBoards(ArrayList<String> myQueenBoard, List<List<String>> answerList, int n, int queensRemaining, int[] currSpot){
        // 1. Check if we are out of spaces
        // 2. Place queen at valid spot and recurse
        // 3. Return values found (or null)
        System.out.println("Here is the current board:");
        for(int i = 0; i < myQueenBoard.size(); ++i){
            System.out.println(myQueenBoard.get(i));
        }
        
        // Place queen at current spot and find the next spot to place the queen until we run out of spots
        // Row
        for(int i = currSpot[0]; i < n; ++i){
            // Starting at new column
            for(int j = 0; j < n; ++j){
                // If we find a character-valid spot we now need to check the diagonals and the horizontals
                if(myQueenBoard.get(i).charAt(j) == '.'){
                    boolean invalid = false;
                    // Checking horizontally
                    System.out.println("Checking Horiz In position: " + i + " " + j);
                    for(int l = 0; l < n; ++l){
                        if((myQueenBoard.get(l).charAt(j) == 'Q') || (myQueenBoard.get(i).charAt(l) == 'Q')){
                            if(myQueenBoard.get(l).charAt(j) == 'Q'){System.out.println("Board found horizontal violation at:" + l + " " + j + " while placing: " + i + " " + j);}
                            if(myQueenBoard.get(i).charAt(l) == 'Q'){System.out.println("Board found horizontal violation at:" + i + " " + l + " while placing: " + i + " " + j);}
                            invalid = true;
                            break;
                        }
                    }
                    if(invalid){continue;}
                    // Checking diagonally
                    int[] topLeftSpot = new int[2];
                    int[] topRightSpot = new int[2];
                    int[] bottomLeftSpot = new int[2];
                    int[] bottomRightSpot = new int[2];
                    for(int k = 0; k < 2; ++k){
                        topLeftSpot[k] = k == 0 ? i : j;
                        topRightSpot[k] = k == 0 ? i : j;
                        bottomLeftSpot[k] = k == 0 ? i : j;
                        bottomRightSpot[k] = k == 0 ? i : j;
                    }
                        
                    // From currSpot to diagonals
                    boolean topRight = true, topLeft = true, bottomRight = true, bottomLeft = true;
                    System.out.println("Checking Vert In position: " + i + " " + j);
                    while(topRight || topLeft || bottomRight || bottomLeft){
                        if(topRight){
                            topRightSpot[0]--;
                            topRightSpot[1]++;
                            if(topRightSpot[0] >= 0 && topRightSpot[1] < n && myQueenBoard.get(topRightSpot[0]).charAt(topRightSpot[1]) == 'Q'){
                                System.out.println("Board found diagonal violation topRight");
                                invalid = true;
                                break;
                            }
                            else if(topRightSpot[0] < 0 || topRightSpot[1] >= n){
                                topRight = false;
                            }
                        }
                        if(topLeft){
                            topLeftSpot[0]--;
                            topLeftSpot[1]--;
                            if(topLeftSpot[0] >= 0 && topLeftSpot[1] >= 0 && myQueenBoard.get(topLeftSpot[0]).charAt(topLeftSpot[1]) == 'Q'){
                                System.out.println("Board found diagonal violation topLeft");
                                invalid = true;
                                break;
                            }
                            else if(topLeftSpot[0] < 0 || topLeftSpot[1] < 0){
                                topLeft = false;
                            }
                        }
                        if(bottomRight){
                            bottomRightSpot[0]++;
                            bottomRightSpot[1]++;
                            if(bottomRightSpot[0] < n && bottomRightSpot[1] < n && myQueenBoard.get(bottomRightSpot[0]).charAt(bottomRightSpot[1]) == 'Q'){
                                System.out.println("Board found diagonal violation bottomRight");
                                invalid = true;
                                break;
                            }
                            else if(bottomRightSpot[0] >= n || bottomRightSpot[1] >= n){
                                bottomRight = false;
                            }
                        }
                        if(bottomLeft){
                            bottomLeftSpot[0]++;
                            bottomLeftSpot[1]--;
                            if(bottomLeftSpot[0] < n && bottomLeftSpot[1] >= 0 && myQueenBoard.get(bottomLeftSpot[0]).charAt(bottomLeftSpot[1]) == 'Q'){
                                System.out.println("Board found diagonal violation bottomLeft");
                                invalid = true;
                                break;
                            }
                            else if(bottomLeftSpot[0] >= n || bottomLeftSpot[1] < 0){
                                bottomLeft = false;
                            }
                        }
                    }
                    if(invalid){continue;}
                    // Place Queen then recurse
                    String prevRow = myQueenBoard.get(i);
                    StringBuilder newRow = new StringBuilder(myQueenBoard.get(i));
                    newRow.setCharAt(j, 'Q');
                    myQueenBoard.set(i, newRow.toString());
                    if(queensRemaining-1 == 0){
                        System.out.println("Found a solution");
                        for(int k = 0; k < myQueenBoard.size(); ++k){
                            System.out.println(myQueenBoard.get(k));
                        }
                        answerList.add(myQueenBoard);
                        return answerList;
                    }
					int[] newCurrSpot = new int[2];
					newCurrSpot[0] = i;
					newCurrSpot[1] = j;
                    List<List<String>> newAnswers = findNQueensBoards(myQueenBoard, answerList, n, queensRemaining-1,newCurrSpot);
                    if(newAnswers != null && newAnswers.size() > answerList.size()){
                        System.out.println("Received solution. New list is now this:");
                        for(int k = 0; k < newAnswers.size(); ++k){
                            for(int l = 0; l < newAnswers.get(k).size(); ++l){
                                System.out.println(newAnswers.get(k).get(l));
                            }
                            System.out.println("\n");
                        }
                        answerList = newAnswers;
                    }
                    myQueenBoard.set(i, prevRow);
                }
            }
        }
		return queensRemaining == n ? answerList : null;
    }
        
    public List<List<String>> solveNQueens(int n) {
        ArrayList<String> myQueenBoard = new ArrayList<String>();
        List<List<String>> answerList = new ArrayList<List<String>>();
        for(int i = 0; i < n; ++i){
            StringBuilder newRow = new StringBuilder();
            for(int j = 0; j < n; ++j){
                newRow.append(".");
            }
            myQueenBoard.add(newRow.toString());
        }
        int[] currSpot = new int[2];
        currSpot[0] = 0;
        currSpot[1] = 0;
        answerList = findNQueensBoards(myQueenBoard, answerList, n, n, currSpot);
        return answerList;
    }

	public static void main(String[] args){
		Solution mySolution = new Solution();
        int n = 4;
        List<List<String>> myAnswer = mySolution.solveNQueens(n);
        System.out.println(myAnswer);
        return;
    }
}
