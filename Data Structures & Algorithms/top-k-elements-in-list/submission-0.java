class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
List<Map.Entry<Integer,Integer>> ls=new ArrayList<>(mpp.entrySet());
        Collections.sort(ls,(a, b) -> b.getValue() - a.getValue());
    int []ans=new int[k];
    for(int i=0;i<k;i++){
        ans[i]=ls.get(i).getKey();
    }
    return ans;
    }
}
