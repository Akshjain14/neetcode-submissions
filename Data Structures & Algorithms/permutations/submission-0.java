class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,curr,ans);
        return ans;
    }
    public void helper(int[] nums, List<Integer> curr,List<List<Integer>> ans){
        if(curr.size()==nums.length){
        ans.add(new ArrayList<>(curr));
        return;
    }
    for(int i=0;i<nums.length;i++){
        if(curr.contains(nums[i]))
        continue;
        curr.add(nums[i]);
        helper(nums,curr,ans);
        curr.remove(curr.size()-1);
    }
    }
}
