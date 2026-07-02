class Solution {
    public int longestConsecutive(int[] nums) {
       
        Map<Integer, Integer> mpp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i],i);
            }
            int ans=0;
            for(int i=0;i<nums.length;i++){
            if(!mpp.containsKey(nums[i]-1)){
            int start=nums[i];
            int len=1;
            while(mpp.containsKey(start+1)){
            start++;
            len++;
            }
            ans=Math.max(len,ans);
        }
            }
        return ans;
    }
}
