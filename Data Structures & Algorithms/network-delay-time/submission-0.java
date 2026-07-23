class Solution {
    class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    class Tuple{
        int node;
        int cost;
        Tuple(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:times){
            int node=it[0];
            int neigh=it[1];
            int  cost=it[2];
            adj.get(node).add(new Pair(neigh,cost));
        }
        int[] dist=new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i]=(int)1e9;
        }
        dist[k]=0;

        PriorityQueue<Tuple> q=new PriorityQueue<>((a,b)-> a.cost-b.cost);
        q.offer(new Tuple(k,0));
        while(!q.isEmpty()){
            Tuple current=q.poll();
            int node=current.node;
            int cost=current.cost;
            if(cost > dist[node])
    continue;
            for(Pair it: adj.get(node)){
                int neigh=it.node;
                int newcost=cost+it.cost;
                if(newcost<dist[neigh]){
                    dist[neigh]=newcost;
                    q.offer(new Tuple(neigh,newcost));
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==(int)1e9)
            return -1;
             ans=Math.max(ans,dist[i]);
        }
       
return ans;
    }
}