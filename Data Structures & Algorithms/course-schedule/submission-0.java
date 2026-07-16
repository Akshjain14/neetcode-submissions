class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=numCourses;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
         }
         int m=prerequisites.length;
         for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
         List<Integer> topo=new ArrayList<>();
         while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);

            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }

         }
         if(topo.size()==n)    return true;
         return false; 
    }
}