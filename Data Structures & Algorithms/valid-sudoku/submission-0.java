class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        //int row=0;
        // int col=0;
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j]!='.')
            if(!issafe(board,i,j))
            return false;
        }
    }
    return true;
    }
    public boolean issafe(char[][] board,int row,int col){
        char ch = board[row][col];
        for(int i=0;i<9;i++){
            if(i!=col && board[row][i]==ch)
            return false;
        }
        for(int j=0;j<9;j++){
            if(j!=row && board[j][col]==ch)
            return false;
        }
    int sr=(row/3)*3;
    int sc=(col/3)*3;
    for(int i=sr;i<=sr+2;i++){
        for(int j=sc;j<=sc+2;j++){
            if((i!=row || j!=col) && board[i][j]==ch)
            return false;
        }
    }
    return true;
    }
}
