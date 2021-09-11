class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distToPoint = {}
        for point in points:
            dist = math.sqrt((point[0])**2 + (point[1])**2)
            if dist in distToPoint.keys():
                distToPoint[dist].append(point)
            else:
                distToPoint[dist] = []
                distToPoint[dist].append(point)
        sortedDistances = [dist for dist in distToPoint.keys()]
        sortedDistances.sort()
        answer = []
        for distance in sortedDistances:
            for point in distToPoint[distance]:
                answer.append(point)
                if(len(answer) == k): return answer
        return answer
