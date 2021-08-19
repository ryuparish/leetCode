class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        s, e = newInterval
        left, right = [], []
        for i in intervals:
            # If the end value is less than the start of newInterval
            # The values to the left of newInterval
            if i[1] < s:
                left += i,
            # If the start value is greater than the end of newInterval
            # The values to the right of the newInterval
            elif i[0] > e:
                right += i,
            # If the interval overlaps, then we try to make the largest interval possible
            # to "eat" them into one interval and we don't add them to the lists
            else:
                s = min(s, i[0])
                e = max(e, i[1])
        print(left)        
        print(right)        
        return left + [[s, e]] + right
