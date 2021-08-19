# This algorithm is called Floyd's Cycle Detection algorithm also known as
# the Tortoise and the Hare. There is a mathematical proof (illusive) that
# states that for any position i, there is a number loops by a 2-step
# incrementer that will always result in xi == x2i (the positions may loop).

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        try:
            leadHead = head.next.next
            lagHead = head.next
            while(leadHead != None or lagHead != None):
                leadHead = leadHead.next.next
                lagHead = lagHead.next
                if(leadHead == lagHead):
                    return True
            return False
        except:
            return False
                
