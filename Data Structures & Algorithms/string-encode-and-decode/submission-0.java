class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans=new StringBuilder();
        for(String s:strs){
            ans.append(s.length());
            ans.append('#');
            ans.append(s);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
         List<String> ls=new ArrayList<>();
         int i=0;
         while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
            j++;
            }
            int len=Integer.parseInt(str.substring(i,j));
            ls.add(str.substring(j+1,j+1+len));
            i=j+1+len;
         }   
         return ls;
    }
}
