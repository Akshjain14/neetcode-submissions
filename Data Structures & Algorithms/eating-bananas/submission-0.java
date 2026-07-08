class Solution {
    public int maxelement(int[]piles){
        int maxi=Integer.MIN_VALUE;
        int n=piles.length;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }
    public int minEatingSpeed(int[] piles, int h) {
      int low=0;
      int high=maxelement(piles);
      while(low<=high){
        int mid=(low+high)/2;
        int totalhours=eatinghours(piles,mid);
        if(totalhours<=h)
        high=mid-1;
        else
        low=mid+1;
      }  
      return low;
    }
    public int eatinghours(int[] piles, int mid){
        int totalhours=0;
        int n=piles.length;
        for(int i=0;i<n;i++){
            totalhours+=Math.ceil((double)piles[i]/mid);
        }
        return totalhours;
    }
}
