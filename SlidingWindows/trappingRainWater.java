// Gist: We use two pointers one from the left and one from the right and continuously check each step if the value at the
// other pointer is smaller. If so, the smaller pointer will always be deciding factor that will determine how much
// water to add to the total. We could use only one pointer if every dip in the pillars returned to the max value found,
// but this is not always the case. This is why we need to know which side has the currently smaller pillar.
// TC: O(n), SC: O(1)
class Solution {
    public int trap(int[] height) {
        int maxRight = height[height.length-1], maxLeft = height[0], leftHead = 0, rightHead = height.length-1;
        int rainWater = 0;
        while(leftHead < rightHead){
            
            // If the current value at the left head is smaller than the right head's value
            if(height[leftHead] < height[rightHead]){
                
                // If we find a new maxLeft
                if(height[leftHead] >= maxLeft){
                    maxLeft = height[leftHead] ;
                }
                
                // If the current leftHead value is not larger than the maxLeft
                else{rainWater += (maxLeft - height[leftHead]);}
                leftHead++;
            }
            
            // If the righthead is larger in value
            else{
                
                // If we find a value with the right head that is greater than the current maxRight
                if(height[rightHead] >= maxRight){
                    maxRight = height[rightHead];
                }
                
                // If the current rightHead is less than the maxRight we get the rain water
                else{
                    rainWater += maxRight - height[rightHead];
                }
                rightHead--;
            }
        }
        return rainWater;
    }
}
