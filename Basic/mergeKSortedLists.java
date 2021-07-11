import java.util.*;

class Solution {
    public static ListNode mergeKLists(ListNode[] lists) {
        // validList is for keeping track of which nodeheads still have to travel
        boolean enough = true;
        ListNode finalList = new ListNode();
        ListNode finalListTail = finalList;
        int smallestHeadValue = 10000, smallestHeadK = 0;

        while(true){
            enough = true;
            smallestHeadValue = 10000;
            for(int i = 0; i < lists.length; ++i){
                if(lists[i] != null && lists[i].val <= smallestHeadValue){
                    smallestHeadValue = lists[i].val;
                    smallestHeadK = i;
                    enough = false;
                }
            }
            if(enough){
                break;
            }
            lists[smallestHeadK] = lists[smallestHeadK].next;
            // Make new node and move the tail to it
            ListNode newNode = new ListNode(smallestHeadValue);
            finalListTail.next = newNode;
            finalListTail = finalListTail.next;
        }
        return finalList.next;
    }
}
