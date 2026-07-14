class Solution {
    public void solve(char[][] board) {
       int rows=board.length;
       int cols=board[0].length;
       boolean[][] visited=new boolean[rows][cols];
     
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(row==0|| row==rows-1|| col==0|| col==cols-1){
                    if(board[row][col]=='O' && !visited[row][col]){
                        bfs(row,col,board,visited);
                        } }  }  } 
        // step 2 to make x all other 0's except safe's zeroes..
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(board[row][col]=='O' && !visited[row][col])
                board[row][col]='X';
            }
        }
    }
        public void bfs(int startrow,int startcol,char[][] board, boolean[][] visited){
             int rows=board.length;
       int cols=board[0].length;
         Queue<int[]> q=new LinkedList<>();
              q.offer(new int[]{startrow,startcol});
              visited[startrow][startcol]=true;

            int[][] directions={
                {0,-1},{0,1},{-1,0},{1,0}
            };
while(!q.isEmpty()){
              int[] current=q.poll();
              int row=current[0];
              int col=current[1];
                for(int[] direction:directions){
                    int nextrow=row+direction[0];
                    int nextcol=col+direction[1];
                    if(nextrow>=0 && nextrow<rows && nextcol>=0 && nextcol<cols 
                    && !visited[nextrow][nextcol] && board[nextrow][nextcol]=='O'){
                        visited[nextrow][nextcol]=true;
                        q.offer(new int[]{nextrow,nextcol});
                    }
                }
        }
        
   }

}