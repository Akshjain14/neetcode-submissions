class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){      
            dist[i][j]=(int)1e9;
        }}
        dist[0][0]=grid[0][0];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[]{grid[0][0],0,0});
         int[][] directions = {
                       {-1, 0 }, {1,0},
                       { 0, -1 }, { 0, 1}
                 };
        while(!pq.isEmpty()){
            int [] current=pq.poll();
            int time=current[0];
            int row=current[1];
            int col=current[2];
    if(row==n-1 && col==m-1)  // check  if you at the destination
    return time;
    if(time > dist[row][col])
    continue;
    for(int[] direction:directions){
                int newrow=row+direction[0];
                int newcol=col+direction[1];
if(newrow>=0 && newrow<n && newcol>=0 && newcol<m){
   int newtime=Math.max(time,grid[newrow][newcol]);
if(newtime<dist[newrow][newcol]){
dist[newrow][newcol]=newtime;
pq.offer(new int[]{newtime,newrow,newcol});
            }
}}
        }
return -1;
    }
}