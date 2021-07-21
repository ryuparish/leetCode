from collections import Counter
from typing import List
class Solution:
    def checkList(self, myCounter) -> bool:
        for value in myCounter.values():
            if value != 0:
                return False
        return True

    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        indexAnswers = []
        jumbleLength = len(words)*len(words[0])
        wordLength = len(words[0])
        for i in range(len(s) -(jumbleLength-1)):
            wordCount = Counter(words)
            currentWindow = s[i:jumbleLength+i]
            for j in range(len(words)):
                currWord = currentWindow[j*wordLength:(j*wordLength)+wordLength];
                if(currWord in words):
                    wordCount[currWord] -= 1
                else:
                    break
            if self.checkList(wordCount):
                indexAnswers.append(i)
        return indexAnswers

def main():
    mySolution = Solution()
    s = "barfoothefoobarman"
    words = ["foo","bar"]
    indices = mySolution.findSubstring(s, words)
    print(indices)
main()

