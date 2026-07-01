class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> mpp=new HashMap<>();
        Map<Character, Integer> mpp1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            mpp.put(ch,mpp.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            mpp1.put(ch,mpp1.getOrDefault(ch,0)+1);
        }
        return mpp.equals(mpp1);
    }
}
