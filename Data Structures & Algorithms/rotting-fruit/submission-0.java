class Solution {
    public int orangesRotting(int[][] grid) {
      int rows=grid.length;
      int cols=grid[0].length;
      Queue<int[]>q=new LinkedList<>();
      int fresh=0;
      for(int i=0;i<rows;i++){
        for(int j=0;j<cols;j++){
            if(grid[i][j]==2)
                q.offer(new int[]{i,j});
        
        else if(grid[i][j]==1)
        fresh++;
        }
      }  
      int min=0;
      int[][] directions={
        {0,-1},{0,1},{-1,0},{1,0}
      };
      while(!q.isEmpty() && fresh>0){
        int size=q.size();
        for(int i=0;i<size;i++){
            int[] current=q.poll();
            int row=current[0];
            int col=current[1];
            for(int[] direction : directions){
                int newrow=row+direction[0];
                int newcol=col+direction[1];
            
            if(newrow>=0 && newrow<rows && newcol>=0 && newcol<cols
            && grid[newrow][newcol]==1){
            grid[newrow][newcol]=2;
            fresh--;
            q.offer(new int[]{newrow,newcol});
        }
        }
        }
        min++;
      }
      if(fresh==0){
return min;
      }
      return -1;
    }
}