class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer,Integer>mpp=new HashMap<>();
      for(int i=0;i<nums.length;i++){
        int num=target-nums[i];
        if(mpp.containsKey(num)){
            return new int[]{mpp.get(num),i};
        }
        else
        mpp.put(nums[i],i);
      }  
      return new int[]{};
    }
}
