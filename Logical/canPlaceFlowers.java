class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int flowersCanBePlaced = 0;
        for (int i = 0; i < flowerbed.length; ++i){
            // If we are looking at a flower that is already planted
            if (flowerbed[i] == 1){
                continue;
            }
            // Check both sides if not on edge
            boolean leftSafe = i == 0 || flowerbed[i-1] == 0;
            boolean rightSafe = i == flowerbed.length-1 || flowerbed[i+1] == 0;

            if (leftSafe && rightSafe){
                flowersCanBePlaced++;
                flowerbed[i] = 1;
            }
        }

        return flowersCanBePlaced >= n;
    }
}
