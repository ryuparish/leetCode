class Solution:
    
    def recursePaths(self, grid: List[List], m: int, n: int) -> int:
        if(grid[m][n] != 0):return grid[m][n]
        
        if(m < len(grid) - 1):
            grid[m][n] = self.recursePaths(grid, m+1, n)
            
        if(n < len(grid[0]) -1):
            grid[m][n] += self.recursePaths(grid, m, n+1)
            
        return grid[m][n]
    
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [[0 for i in range(n)] for j in range(m)]
        grid[m-1][n-1] = 1
        return self.recursePaths(grid, 0, 0)
