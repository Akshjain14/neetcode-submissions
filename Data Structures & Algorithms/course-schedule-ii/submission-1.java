class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> adj=new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         int m=prerequisites.length;
         for(int i=0;i<m;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
         }
         int[] indegree=new int[n];
         for(int i=0;i<n;i++){
         for(int it:adj.get(i)){
            indegree[it]++;
         }
         }
         Queue<Integer> q=new LinkedList<>();
         for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
         }
       // List<Integer> topo=new ArrayList<>();
       int[] topo=new int[n];
       int i=0;
         while(!q.isEmpty()){
            int node=q.poll();
          //  q.remove();
            topo[i++]=node;

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }

         }
         if(i==n) return topo;
         else
         return new int[]{};
           
    }
}