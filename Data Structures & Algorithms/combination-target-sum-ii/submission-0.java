class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, candidates, target, current, ans);
        return ans;
    }

    public void backtrack(int index, int[] candidates, int target,
            List<Integer> current, List<List<Integer>> ans) {
       
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        current.add(candidates[index]);
        backtrack(index + 1, candidates, target - candidates[index], current, ans);

        current.remove(current.size() - 1);
        
        int nextindex = index + 1;
        while (nextindex < candidates.length && candidates[nextindex] == candidates[index])
            nextindex++;
        backtrack(nextindex, candidates, target, current, ans);
    }

}
