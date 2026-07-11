class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer>curr=new ArrayList<>();
    List<List<Integer>> ans=new ArrayList<>();
    Arrays.sort(nums);
    helper(0,nums,curr,ans);
    return ans;
    }
    public void helper(int index, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(index==nums.length){
            ans.add(new ArrayList<>(curr));
            return ;
        }
        curr.add(nums[index]);
         helper(index+1,nums,curr,ans);
        curr.remove(curr.size()-1);
        int nextindex=index+1;
        while(nextindex<nums.length && nums[nextindex]==nums[index])
        nextindex++;
        helper(nextindex, nums,curr,ans);
        

    }
}
