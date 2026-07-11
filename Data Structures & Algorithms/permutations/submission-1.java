class Solution {
    /*public List<List<Integer>> permute(int[] nums) {
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
    }*/
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,ans);
        return ans;
    }
    public void helper(int index, int[] nums, List<List<Integer>>ans){
        if(index==nums.length){
            List<Integer>curr=new ArrayList<>();
            for(int num: nums)
            curr.add(num);

            ans.add(curr);
            return;
        }
            for(int i=index; i<nums.length;i++){
                swap(nums,index,i);
                helper(index+1,nums,ans);
                swap(nums,index,i);
            }
        }
        public void swap(int[] nums, int i, int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

    }

