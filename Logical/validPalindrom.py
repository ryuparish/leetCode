from string import ascii_letters, digits
# Definitely need to know some python libraries for this one
class Solution:
    def isPalindrome(self, s: str) -> bool:
        newString = ''.join(character for character in s if character in ascii_letters or character in digits)
        newString = newString.lower()
        for idx, character in enumerate(newString):
            if(newString[idx] != newString[len(newString) - (1 + idx)]):
                return False
        return True
            
