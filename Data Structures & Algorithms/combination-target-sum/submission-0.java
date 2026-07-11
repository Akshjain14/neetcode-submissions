class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>curr=new ArrayList<>();
        helper(0,nums,curr,ans,target);
        return ans;
    }
    public void helper(int index,int[] nums, List<Integer> curr, List<List<Integer>>ans,int target){
        if(target==0){
        ans.add(new ArrayList<>(curr));
        return;
        }
         if(target<0 || index==nums.length)
         return;

         curr.add(nums[index]);
         helper(index,nums,curr,ans,target-nums[index]);
         curr.remove(curr.size()-1);
         helper(index+1,nums,curr,ans,target);
    }
}
