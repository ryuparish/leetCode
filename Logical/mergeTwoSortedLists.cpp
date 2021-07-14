/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* travel(int& val, ListNode*& travelingNode){
        while(travelingNode->next != NULL && travelingNode->next->val <= val){
            travelingNode = travelingNode->next;
        }
        return travelingNode;
    } 
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* holder = NULL;
        ListNode* headNode = NULL;
        // Both can be compared
        if(l1 != NULL && l2 != NULL && l1->val > l2->val){
            headNode = l2;
        }
        // l2 is null
        else if(l1 != NULL && l2 == NULL){
            return l1;
        }
        // l1 is null
        else if(l2 !=  NULL && l1 == NULL){
            return l2;
        }
        // l1 is smaller 
        else{
            headNode = l1;
        }

        // Traveling and ordering nodes until one list runs out
        while(l1 != NULL && l2 != NULL){
            if(l1->val > l2->val){
                l2 = travel(l1->val, l2);
                holder = l2;
                l2 = l2->next;
                holder->next = l1;
            }
            else{
                l1 = travel(l2->val, l1);
                holder = l1;
                l1 = l1->next;
                holder->next = l2;
            }
        }
        return headNode;
    }
};
