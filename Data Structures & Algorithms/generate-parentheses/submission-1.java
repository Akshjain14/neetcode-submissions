class Solution {
    public List<String> generateParenthesis(int n) {
        int opencnt=0;
        int closecnt=0;
        int totalcnt=0;
        List<String>ans=new ArrayList<>();
        String res="";
        helper(res,opencnt,closecnt,n,ans,totalcnt);
        return ans;
    }
    public void helper(String res, int opencnt, int closecnt,int n,List<String>ans,int totalcnt){
        totalcnt=opencnt+closecnt;
        if(totalcnt==2*n){
            ans.add(res);
            return;
        }

        if(opencnt<n){
            helper(res+'(',opencnt+1,closecnt,n,ans,totalcnt);
        }
        if(closecnt<opencnt){
            helper(res+')',opencnt,closecnt+1,n,ans,totalcnt);

        }
       
    }
}
