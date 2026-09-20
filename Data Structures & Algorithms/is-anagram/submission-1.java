class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer>mpp=new HashMap<>();
        HashMap<Character, Integer>mpp1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
           mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char sh=t.charAt(i);
          mpp1.put(sh,mpp1.getOrDefault(sh,0)+1);
        }
       return mpp.equals(mpp1);
    }
}
