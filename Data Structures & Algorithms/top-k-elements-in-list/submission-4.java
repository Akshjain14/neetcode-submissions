class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;                         
        HashMap<Integer,Integer>mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
// a[1],b[1] because we compare freq, in array we store[key, freq] so its a index..
        for(Map.Entry<Integer,Integer>entry:mpp.entrySet()){ // take pair from map
            pq.offer(new int[]{entry.getKey(),entry.getValue()});//put in pq
        
        if(pq.size()>k){//sirf vo bachega jo kaam kai hai elements kyunki smaller vale poll hojayenge...
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
