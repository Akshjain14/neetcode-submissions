class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int maxfreq=0;
        int maxlength=0;

        Map<Character, Integer> mpp=new HashMap<>();
        for(int right=0;right<s.length();right++){
           char ch=s.charAt(right);
           mpp.put(ch,mpp.getOrDefault(ch,0)+1);
           maxfreq=Math.max(maxfreq,mpp.get(ch));
           while((right-left+1)-maxfreq>k){
            char leftchar=s.charAt(left);
            mpp.put(leftchar,mpp.getOrDefault(leftchar,0)-1);
                    left++;
           }
           maxlength=Math.max(maxlength,right-left+1);
        }
        return maxlength;        
    }
}
