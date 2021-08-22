class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        currExp = 0
        answer = 0
        for idx in range(len(columnTitle) - 1, -1, -1):
            answer += (26 **currExp) * (ord(columnTitle[idx]) - 64)
            currExp += 1
        return answer
