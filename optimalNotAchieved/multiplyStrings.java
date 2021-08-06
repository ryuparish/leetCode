class Solution {
    public int stringConverter(String num){
        long finalNum = 0;
        for(int i = 0; i < num.length(); ++i){
            // Converting from char to ASCII
            int actualValue = (int)num.charAt(i) - 48;
            finalNum += actualValue * (Math.pow(10, (num.length() - (i+1))));
        }
        return finalNum;
    }
    public String multiply(String num1, String num2) {
        long product = (stringConverter(num1) * stringConverter(num2));
        StringBuilder answer = new StringBuilder();
        while(product > 0){
            int digit = (product % 10);
            char digitChar = (char)digit;
            digitChar += '0';
            answer.append(digitChar);
            product /= 10;
        }
        return answer.reverse().toString();
    }
	public static void main(String[] args){
        Solution mySolution = new Solution();
        String string1 = "100";
        String string2 = "120";
        System.out.println(mySolution.multiply(string1, string2));
        return;
    }
}
