class Solution {
    public int maxArea(int[] heights) {
        int ans=Integer.MIN_VALUE;
        int left=0;
        int right=heights.length-1;
        while(left<right){
            int area=(right-left)*Math.min(heights[left],heights[right]);
            if(heights[left]<heights[right])
            left++;
            else
            right--;
            ans=Math.max(ans,area);
        }
        return ans;

    }
}
