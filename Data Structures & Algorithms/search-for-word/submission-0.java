class Solution {
    public boolean exist(char[][] board, String word) {
      int rows=board.length;
      int cols=board[0].length;;
      for(int row=0;row<rows;row++){
        for(int col=0;col<cols;col++){
            if(helper(row,col,0,board,word))
            return true;
        }
      }  
      return false;
    }
    public boolean helper(int row,int col ,int index, char[][] board, String word){
        if(index==word.length())
return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }
        if(board[row][col]!=word.charAt(index))
        return false;
        char temp=board[row][col];
        board[row][col]='#';
        boolean found=helper(row-1,col,index+1, board,word) ||
         helper(row+1,col,index+1,board,word) ||
          helper(row,col+1,index+1,board,word)||
          helper(row,col-1,index+1,board,word);
        board[row][col]=temp;  // backtrack
        return found;
    }
}
