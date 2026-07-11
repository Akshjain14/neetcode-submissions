class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0){
            return ans;
        }
        String[] mapping={
            "","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" 
        };
        helper(0,"",digits,mapping,ans);
        return ans;
    }
    public void helper(int index,String curr,String digits,String[] mapping,List<String>ans){
        if(index==digits.length()){
            ans.add(curr);
            return;
        }
        int digit=digits.charAt(index)-'0';
        String letters=mapping[digit];
        for(int i=0;i<letters.length();i++){
            char ch=letters.charAt(i);
        helper(index+1,curr+ch,digits,mapping,ans);
        }
    }
}