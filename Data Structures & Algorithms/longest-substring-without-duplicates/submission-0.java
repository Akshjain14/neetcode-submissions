class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> ss=new HashSet<>();
        int left=0; 
        int maxi=0;
        for(int right=0;right<s.length();right++){
                while(ss.contains(s.charAt(right))){
                    ss.remove(s.charAt(left));
                    left++;
                }
                ss.add(s.charAt(right));
            maxi=Math.max(maxi,right-left+1);
        }
        return maxi;
    }
}
