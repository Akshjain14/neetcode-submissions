class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        
        if(pq.size()>k){
            pq.poll();
        }
    }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}
