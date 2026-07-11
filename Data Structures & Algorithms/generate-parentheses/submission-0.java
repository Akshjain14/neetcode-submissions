class Solution {
    public List<String> generateParenthesis(int n) {
        int opencnt=0;
        int closecnt=0;
        List<String>ans=new ArrayList<>();
        String res="";
        helper(res,opencnt,closecnt,n,ans);
        return ans;
    }
    public void helper(String res, int opencnt, int closecnt,int n,List<String>ans){
        if(opencnt==n && closecnt==n){
            ans.add(res);
            return;
        }
        if(opencnt<n){
            helper(res+'(',opencnt+1,closecnt,n,ans);
        }
        if(closecnt<opencnt){
            helper(res+')',opencnt,closecnt+1,n,ans);
        }
    }
}
