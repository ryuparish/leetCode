import java.util.*;
import java.lang.Math;
class Solution{
    public static int threeSumClosest(int[] nums, int target){
        int sumChamp = 0;
        if(nums.length <= 2){return sumChamp;}
        // With this method, duplicates are of no worry because we always explicitly skip over redundant/duplicate searches
        // Sort the list
        Arrays.sort(nums);
        // Make the pointers
        int frontHead, backHead, minDiff = 1000;
        for(int i = 0; i < nums.length; ++i){
            frontHead = i + 1;
            backHead = nums.length - 1;
            
            // For running over redundant searches
            if(i > 0 && nums[i] == nums[i-1]){continue;}

            int sum;
            while(backHead > frontHead){
                //System.out.println("i:" + nums[i] + " frontHead: " + nums[frontHead] + " backHead: " + nums[backHead]);
                sum = nums[i] + nums[frontHead] + nums[backHead];
				//System.out.println("Current minDiff:" + minDiff + " Current sum: " + sum + " Current Math.abs(target-sum): " + Math.abs(target-sum));
                if(Math.abs(target - sum) < minDiff){
                    //System.out.println("Made it inside conditional");
                    minDiff = Math.abs(target - sum);
                    //System.out.println("MinDiff changed to:" + minDiff);
                    sumChamp = sum;
                    if(minDiff == 0){
                        ++frontHead;
                        --backHead;
                    }
                }
                if(Math.abs(target - sum) > 0 && sum > target){
                    //System.out.println("backHead moved back");
                    --backHead;
                    while(backHead > frontHead && backHead+1 < nums.length && nums[backHead] == nums[backHead +1]){
                        --backHead;
                    }
                }
                else{
                    ++frontHead;
                    //System.out.println("frontHead moved up");
                    while(backHead > frontHead && frontHead-1 >= 0 && nums[frontHead] == nums[frontHead - 1]){
                        ++frontHead;
                    }
                }
            }
        }
        return sumChamp;
    }

	//public static void main(String[] args){
    //    int[] myArray = {-1, 2, 1, -4};
    //    int myTarget = 1;
    //    int myAnswer = threeSumClosest(myArray, myTarget);
    //    System.out.println(myAnswer);
    //}
};
