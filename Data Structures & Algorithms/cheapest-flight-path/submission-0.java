class Solution {
     class Pair {
        int node;
        int cost;

        Pair( int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    class Tuple{
        int stops;
        int node;
        int cost;

        Tuple(int stops, int node, int cost){
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }
      for(int[] it:flights){
        int from=it[0];
        int to=it[1];
        int cost=it[2];
        adj.get(from).add(new Pair(to,cost));
      }
      int[] dist=new int[n];
      Arrays.fill(dist,(int)1e9);
      dist[src]=0;

      Queue<Tuple> q=new LinkedList<>();
      q.add(new Tuple(0,src,0));
      while(!q.isEmpty()){
        Tuple current=q.poll();
        int stops=current.stops;
        int node=current.node;
        int cost=current.cost;
        if(stops>k)  continue;
        for(Pair it:adj.get(node)){
            int neigh=it.node;
            int newcost=cost+it.cost;
            if(newcost<dist[neigh]){
                dist[neigh]=newcost;
            q.add(new Tuple(stops+1,neigh,newcost));
        }
        }
      }
      if(dist[dst]==(int)1e9){
        return -1;
      }
      return dist[dst];
    }
}