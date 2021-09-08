# Use 2 hashmaps, one for the 3x3 grid, one for the row and column
# Definitely could be improved since we check the rows (3 of them) for every 3x3 square and we also check the columns (3 of them) every time even when we move down ward to the set of second 3x3 grids.
class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for vertIdx, _ in enumerate(board[::3]): # 0, 1, 2 down the column
            vertIdx *= 3
            
            for horizIdx, _ in enumerate(board[vertIdx][::3]): # 0, 1, 2 across the row
                horizIdx *= 3
                # First we need to check if the 3x3 grid is valid
                # and while we do so, we can also check that the rows and the columns are valid
                
                gridDict = Counter()
                for row in range(3):
                    # vertIdx + 1, vertIdx + 2...
                    row = vertIdx + row
                    lineDict = Counter()
                    
                    for rowValue in board[row]:
                        if(rowValue != "."):
                            lineDict[rowValue] += 1
                        if((lineDict[rowValue]) > 1):
                            return False
                        
                    for column in range(3):
                        column = horizIdx + column
                        gridValue = board[row][column]
                        
                        # Duplicate in grid
                        if(gridValue != "."):
                            gridDict[board[row][column]] += 1
                        if((gridDict[board[row][column]]) > 1):
                            return False
                        
                        # Now column of the current element
                        lineDict.clear()
                        for columnValue in board:
                            columnElement = columnValue[column]
                            if(columnElement != "."):
                                lineDict[columnElement] += 1
                            if((lineDict[columnElement]) > 1):
                                return False
        return True
