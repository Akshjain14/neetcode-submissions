class TimeMap {
    class Pair{
        int timestamp;
        String value;
        
        Pair(int timestamp, String value){
            this.timestamp=timestamp;
            this.value=value;
        }
    }
    Map<String, List<Pair>> mpp=new HashMap<>();
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mpp.containsKey(key)){
        mpp.put(key,new ArrayList<>());
        }
        mpp.get(key).add(new Pair(timestamp,value));
    }
    public String get(String key, int timestamp) {
        if(!mpp.containsKey(key))
        return "";
        List<Pair>ls=mpp.get(key);
        int low=0;
        int high=ls.size()-1;
        String ans="";
        while(low<=high){
            int mid=(low+high)/2;
            if(ls.get(mid).timestamp<=timestamp){
          //  ans=ls.get(mid).value;
            low=mid+1;
        }
        else
        high=mid-1;
        }
       // return ans;  either write simply
       return high>=0?ls.get(high).value:"";
    }
}
