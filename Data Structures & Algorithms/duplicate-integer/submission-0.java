class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> mpp=new HashMap<>();
        for(int i=0;i<n;i++){
            if(mpp.containsValue(nums[i]))
            return true;
            else
                mpp.put(i,nums[i]);
        }
        return false;
    }
}