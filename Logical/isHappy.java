class Solution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int sum = 0;
        while(true){
            while(n > 0){
                sum += Math.pow((n % 10), 2);
                n /= 10;
            }
            if(sum == 1){return true;}
            if(myMap.containsKey(sum)){return false;}
            myMap.put(sum, 1);
            n = sum;
            sum = 0;
        }
    }
}
