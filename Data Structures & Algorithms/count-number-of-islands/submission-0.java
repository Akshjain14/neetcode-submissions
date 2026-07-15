class Solution {
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int islands=0;
        boolean[][] visited =new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(grid[row][col]=='1' && !visited[row][col]){
                    dfs(row,col,grid,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfs(int row, int col, char[][] grid, boolean[][] visited){
        int rows=grid.length;
        int cols=grid[0].length;
    visited[row][col]=true;
    int[][] directions={{0,-1},{0,1},{-1,0},{1,0}};

    for(int[] direction: directions){
        int newrow=row+direction[0];
        int newcol=col+direction[1];
        if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols && 
        grid[newrow][newcol]=='1' && !visited[newrow][newcol])
        dfs(newrow, newcol,grid,visited);
    }
        }

    }
