class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        List<List<String>>ans=new ArrayList<>();
        helper(board,0,n,ans);
        return ans;
    }
    public void helper(char[][] board,int row, int n,List<List<String>>ans){
        if(row==n){
            List<String>temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }
        for(int i=0;i<n;i++){
            if(issafe(board,row,i,n)){
                board[row][i]='Q';
                helper(board,row+1,n,ans);
                board[row][i]='.';
            }
        }
    }
    public boolean issafe(char[][] board,int row,int col,int n){
        for(int i=0;i<n;i++){  // vertically check
            if(board[row][i]=='Q')
            return false;
        }
        for(int i=0;i<n;i++){  // horizontally check
            if(board[i][col]=='Q')
            return false;
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--){ // left diagonal
            if(board[i][j]=='Q')
            return false;
        }
        for(int i=row,j=col;i>=0 && j<n;i--,j++){ // right diagonal
        if(board[i][j]=='Q')
        return false;
        }
        return true;
    }
}
