class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mpp= new HashMap<>();

       for(int i=0;i<strs.length;i++){
        int[] freq=new int[26];
        for(int j=0;j<strs[i].length();j++){
            char ch=strs[i].charAt(j);
        freq[ch-'a']++;     // this is how i got the indexes..       
        }
  String key=Arrays.toString(freq);
      if(!mpp.containsKey(key)){
    mpp.put(key,new ArrayList<>());
}
mpp.get(key).add(strs[i]);
        } 
      return new ArrayList<>(mpp.values());
    }
}
